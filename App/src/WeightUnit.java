public enum WeightUnit implements IMeasurable {
    KILOGRAM(1000.0),
    GRAM(1.0);

    private final double toBaseFactor; // base = gram

    WeightUnit(double factor) {
        this.toBaseFactor = factor;
    }

    public double toBaseUnit(double value) {
        return value * toBaseFactor;
    }

    public double fromBaseUnit(double baseValue) {
        return baseValue / toBaseFactor;
    }
}