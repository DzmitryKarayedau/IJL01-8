package com.emerline.ijl01_8.util;

import com.emerline.ijl01_8.exception.NegativeValueException;
import com.emerline.ijl01_8.exception.ZeroValueException;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by dzmitry.karayedau on 14-Apr-17.
 */
public abstract class CurrencyConverter {

    private BigDecimal rate;
    private int fractionDigits;

    public void CurrencyConverter(String currency, BigDecimal rate) {
        this.rate = rate;
        fractionDigits = this.returnFractionDigits(currency);
    }


    public BigDecimal convertCurrency(BigDecimal moneyCount) throws ZeroValueException, NegativeValueException {
        validateData(rate, moneyCount);
        BigDecimal resultMoney = moneyCount.divide(rate, fractionDigits, BigDecimal.ROUND_HALF_UP);
        return resultMoney;
    }

    private int returnFractionDigits(String currency) {
        try {
            if (currency == "BYR") {
                return 2;
            } else {
                return Currency.getInstance(currency).getDefaultFractionDigits();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Wrong currency name");
            return -1;
        }
    }

    private void validateData(BigDecimal rate, BigDecimal moneyCount) throws NegativeValueException, ZeroValueException {
        if ((rate == null)|(moneyCount == null)) {
            throw new NullPointerException();
        }
        if (rate.equals(BigDecimal.ZERO)) {
            throw new ZeroValueException("Zero currency");
        }
        if ((rate.compareTo(BigDecimal.ZERO) < 0) | (moneyCount.compareTo(BigDecimal.ZERO) < 0)) {
            throw new NegativeValueException("Negative value");
        }
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

}
