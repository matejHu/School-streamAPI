import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathUtils {

    public static double roundToDecimalPlace(double value, int places) {
        if (places < 0) throw new IllegalArgumentException("Places must be non-negative");

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}