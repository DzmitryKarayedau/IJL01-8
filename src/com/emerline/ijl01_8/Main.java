package com.emerline.ijl01_8;

import com.emerline.ijl01_8.exception.NegativeValueException;
import com.emerline.ijl01_8.exception.ZeroValueException;
import com.emerline.ijl01_8.util.CurrencyConverter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        double rate;
        double moneyCount;

        try {
            System.out.print("Input currency rate: ");
            rate = in.nextDouble();
            System.out.print("input money count: ");
            moneyCount = in.nextDouble();
            System.out.printf("Converted money = %.2f%n ", CurrencyConverter.convertCurrency("USD", rate, moneyCount));

        } catch (InputMismatchException e) {
            System.err.println("Wrong input data");
        } catch (NegativeValueException e) {
            System.err.println("Negative value");
        } catch (ZeroValueException e) {
            System.err.println("Zero value");
        }

    }
}
