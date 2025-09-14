public class DiscountResult {
    private final double newValue;
    private final double deduction;

    public DiscountResult(double newValue, double deduction) {
        this.newValue = newValue;
        this.deduction = deduction;
    }

    public double getNewValue() {
        return newValue;
    }

    public double getDeduction() {
        return deduction;
    }
}
