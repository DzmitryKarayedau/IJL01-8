import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by dzmitry.karayedau on 14-Apr-17.
 */
public class CurrencyConverter {

    private static final int[] FRACTION_DIGITS = new int[]{1, 10, 100, 1000};


    public static double convertCurrency(String toCur, double rate, double moneyCount) {
        int toFractionDigits = returnFractionDigits(toCur);
        double result;

        result = moneyCount / rate;
        result = result * FRACTION_DIGITS[toFractionDigits];
        result = Math.round(result);
        result = result / FRACTION_DIGITS[toFractionDigits];
        return result;


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
}
