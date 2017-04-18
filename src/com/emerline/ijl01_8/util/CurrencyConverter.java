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

    public CurrencyConverter(String currency, BigDecimal rate) throws ZeroValueException, NegativeValueException {
        validateRate(rate);
        this.rate = rate;
        fractionDigits = this.fractionDigits(currency);
    }


    public BigDecimal convertCurrency(BigDecimal moneyCount) throws ZeroValueException, NegativeValueException {
        validateMoney(moneyCount);
        BigDecimal resultMoney = moneyCount.divide(rate, fractionDigits, BigDecimal.ROUND_HALF_UP);
        return resultMoney;
    }

    private int fractionDigits(String currency) {
        try {
            if (currency == "BYN") {
                return 2;
            } else {
                return Currency.getInstance(currency).getDefaultFractionDigits();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Wrong currency name");
            return -1;
        }
    }

    private void validateRate(BigDecimal rate) throws NegativeValueException, ZeroValueException {
        if (rate == null) {
            throw new NullPointerException("Rate is null");
        }
        if (rate.equals(BigDecimal.ZERO)) {
            throw new ZeroValueException("Zero currency");
        }
        if (rate.compareTo(BigDecimal.ZERO) < 0) {
            throw new NegativeValueException("Negative value");
        }
    }

    private void validateMoney(BigDecimal moneyCount) throws NegativeValueException, ZeroValueException {
        if (moneyCount == null) {
            throw new NullPointerException("Money is null");
        }
        if (moneyCount.compareTo(BigDecimal.ZERO) < 0) {
            throw new NegativeValueException("Negative value");
        }
    }

    public BigDecimal getRate() {
        return rate;
    }


}
