package com.emerline.ijl01_8.util;

import com.emerline.ijl01_8.exception.NegativeValueException;
import com.emerline.ijl01_8.exception.ZeroValueException;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by dzmitry.karayedau on 14-Apr-17.
 */
public class CurrencyConverter {

    private static final int[] FRACTION_DIGITS = new int[]{1, 10, 100, 1000};


    public static double convertCurrency(String toCurrency, double rate, double moneyCount) throws ZeroValueException, NegativeValueException {
        validateData(rate, moneyCount);
        int toFractionDigits = returnFractionDigits(toCurrency);
        BigDecimal rateMoney = new BigDecimal(rate);
        BigDecimal countMoney = new BigDecimal(moneyCount);
        BigDecimal resultMoney = countMoney.divide(rateMoney, toFractionDigits, BigDecimal.ROUND_HALF_UP);
        return resultMoney.doubleValue();

    }

    private static int returnFractionDigits(String currency) {
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

    private static void validateData(double rate, double moneyCount) throws NegativeValueException, ZeroValueException {
        if (rate == 0) {
            throw new ZeroValueException("Zero currency");
        }
        if ((rate < 0) | (moneyCount < 0)) {
            throw new NegativeValueException("Negative value");
        }
    }
}
