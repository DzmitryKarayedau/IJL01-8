package com.emerline.ijl01_8.test;

import com.emerline.ijl01_8.util.CurrencyConverterToUSD;

import java.math.BigDecimal;

import static junit.framework.Assert.*;

/**
 * Created by dzmitry.karayedau on 17-Apr-17.
 */
public class CurrencyConverterToUSDTest {
    CurrencyConverterToUSD currencyConverterToUSD = new CurrencyConverterToUSD(new BigDecimal(Math.random() + 1));

    @org.junit.Before
    public void setUp() throws Exception {
        currencyConverterToUSD = new CurrencyConverterToUSD(new BigDecimal(Math.random() + 1));
    }

    @org.junit.After
    public void tearDown() throws Exception {
        currencyConverterToUSD = null;
    }

    @org.junit.Test
    public void convertCurrency() throws Exception {
        BigDecimal countMoney = new BigDecimal(Math.pow(Math.random(), 1 / Math.random()));
        BigDecimal rate = currencyConverterToUSD.getRate();
        assertEquals(countMoney.divide(rate, 2, BigDecimal.ROUND_HALF_UP), currencyConverterToUSD.convertCurrency(countMoney));
    }

    @org.junit.Test
    public void getCurrency() throws Exception {
        assertEquals("Must Be USD", "USD", currencyConverterToUSD.getCurrency());
    }

    @org.junit.Test
    public void setRate() throws Exception {
        BigDecimal rate = new BigDecimal(Math.random() + 1);
        currencyConverterToUSD.setRate(rate);
    }

    @org.junit.Test
    public void getRate() throws Exception {
        assertNotNull(currencyConverterToUSD.getRate());
    }


}