public enum LengthUnit implements IMeasurable {
    FEET(12.0),
    INCHES(1.0);

    private final double toBaseFactor; // base = inches

    LengthUnit(double toBaseFactor) {
        this.toBaseFactor = toBaseFactor;
    }

    public double toBaseUnit(double value) {
        return value * toBaseFactor;
    }

    public double fromBaseUnit(double baseValue) {
        return baseValue / toBaseFactor;
    }
}