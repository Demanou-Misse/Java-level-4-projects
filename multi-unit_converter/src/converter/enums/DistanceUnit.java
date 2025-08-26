package converter.enums;

public enum DistanceUnit {
    KM_TO_MILES(0.621371),
    MILES_TO_KM(1.609344),
    KM_TO_METERS(1000.0),
    METERS_TO_KM(0.001),
    MILES_TO_METERS(1609.344),
    METERS_TO_MILES(1.0 / 1609.344);

    private double value;

    DistanceUnit(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
