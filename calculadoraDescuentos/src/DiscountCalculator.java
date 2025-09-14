public class DiscountCalculator {
    public static DiscountResult valueDiscount(double value, int percent) {
        double nValue = value - (value * percent / 100.0);
        double deduction = value - nValue;
        return new DiscountResult(nValue, deduction);
    }
}
