package com.emerline.ijl01_8.util;

import com.emerline.ijl01_8.exception.NegativeValueException;
import com.emerline.ijl01_8.exception.ZeroValueException;

import java.math.BigDecimal;

/**
 * Created by dzmitry.karayedau on 17-Apr-17.
 */
public class CurrencyConverterToUSD extends CurrencyConverter {

    private final static String CURRENCY = "USD";

    public BigDecimal convertCurrency(BigDecimal moneyCount) throws ZeroValueException, NegativeValueException {
        return super.convertCurrency(moneyCount);
    }

    public CurrencyConverterToUSD(BigDecimal rate) {
        super.CurrencyConverter(CURRENCY , rate);
    }

    public String getCurrency() {
        return CURRENCY;
    }

    public void setRate(BigDecimal rate) {
        super.setRate(rate);
    }

    public BigDecimal getRate() {
        return super.getRate();
    }

}
