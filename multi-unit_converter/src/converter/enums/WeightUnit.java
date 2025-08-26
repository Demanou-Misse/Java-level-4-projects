package converter.enums;

public enum WeightUnit {
    KG_TO_POUNDS(2.20462),
    POUNDS_TO_KG(0.453592);

    private double value;

    WeightUnit (double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
