package com.emerline.ijl01_8;

import com.emerline.ijl01_8.exception.NegativeValueException;
import com.emerline.ijl01_8.exception.ZeroValueException;
import com.emerline.ijl01_8.util.CurrencyConverter;
import com.emerline.ijl01_8.util.CurrencyConverterToUSD;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        CurrencyConverterToUSD currencyConverterToUSD;
        BigDecimal rate;
        BigDecimal moneyCount;

        try {
            System.out.print("Input currency rate: ");
            rate = in.nextBigDecimal();
            currencyConverterToUSD = new CurrencyConverterToUSD(rate);
            System.out.print("input money count: ");
            moneyCount = in.nextBigDecimal();
            System.out.printf("Converted money = %.2f%n ", currencyConverterToUSD.convertCurrency(moneyCount));
        } catch (InputMismatchException e) {
            System.err.println("Wrong input data");
        } catch (NegativeValueException e) {
            System.err.println("Negative value");
        } catch (ZeroValueException e) {
            System.err.println("Zero value");
        }

    }
}
