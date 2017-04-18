package com.emerline.ijl01_8.test;

import com.emerline.ijl01_8.exception.NegativeValueException;
import com.emerline.ijl01_8.exception.ZeroValueException;
import com.emerline.ijl01_8.util.CurrencyConverterToUSD;

import java.math.BigDecimal;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by dzmitry.karayedau on 17-Apr-17.
 */
public class CurrencyConverterToUSDTest {
    CurrencyConverterToUSD currencyConverterToUSD = new CurrencyConverterToUSD(new BigDecimal(Math.random() + 1));

    public CurrencyConverterToUSDTest() throws ZeroValueException, NegativeValueException {
    }

    @Before
    public void setUp() throws Exception {
        currencyConverterToUSD = new CurrencyConverterToUSD(new BigDecimal(Math.random() + 1));
    }

    @After
    public void tearDown() throws Exception {
        currencyConverterToUSD = null;
    }

    @Test
    public void convertCurrency_MoneyAndRate_CountOfUsd() throws Exception {
        BigDecimal countMoney = new BigDecimal(Math.pow(Math.random(), 1 / Math.random()));
        BigDecimal rate = currencyConverterToUSD.getRate();
        assertEquals(countMoney.divide(rate, 2, BigDecimal.ROUND_HALF_UP), currencyConverterToUSD.convertCurrency(countMoney));
    }

    @Test
    public void getCurrency_USD() throws Exception {
        assertEquals("Must Be USD", "USD", currencyConverterToUSD.getCurrency());
    }

    @Test
    public void getRate_NotNull() throws Exception {
        assertNotNull(currencyConverterToUSD.getRate());
    }

    @Test(expected = NegativeValueException.class)
    public void convertCurrency_NegativeValue_NegativeValueException() throws Exception {
        BigDecimal countMoney = new BigDecimal(Math.pow(Math.random(), 1 / Math.random())).negate();
        currencyConverterToUSD.convertCurrency(countMoney);
    }

    @Test(expected = NegativeValueException.class)
    public void currencyConverterToUSD_NegativeValue_NegativeValueException() throws Exception {
        BigDecimal rate = new BigDecimal(Math.pow(Math.random(), 1 / Math.random())).negate();
        new CurrencyConverterToUSD(rate);
    }

    @Test(expected = ZeroValueException.class)
    public void currencyConverterToUSD_ZeroValue_ZeroValueException() throws Exception {
        new CurrencyConverterToUSD(BigDecimal.ZERO);
    }

    @Test(expected = NullPointerException.class)
    public void convertCurrency_Null_NullPointerException() throws Exception {
        currencyConverterToUSD.convertCurrency(null);
    }


}