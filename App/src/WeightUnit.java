public enum WeightUnit implements IMeasurable {

    KILOGRAM(1000.0),
    GRAM(1.0);

    private final double factor;

    WeightUnit(double factor) {
        this.factor = factor;
    }

    public double toBaseUnit(double value) {
        return value * factor;
    }

    public double fromBaseUnit(double baseValue) {
        return baseValue / factor;
    }
}