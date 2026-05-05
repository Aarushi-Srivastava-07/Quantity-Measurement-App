public final class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, this.unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        validate(other, targetUnit);

        double baseThis = unit.toBaseUnit(this.value);
        double baseOther = other.unit.toBaseUnit(other.value);

        double baseResult = baseThis - baseOther;

        double converted = targetUnit.fromBaseUnit(baseResult);

        return new Quantity<>(round(converted), targetUnit);
    }

    public double divide(Quantity<U> other) {
        validate(other, this.unit);

        double baseThis = unit.toBaseUnit(this.value);
        double baseOther = other.unit.toBaseUnit(other.value);

        if (baseOther == 0.0) {
            throw new ArithmeticException("Division by zero");
        }

        return baseThis / baseOther;
    }

    private void validate(Quantity<U> other, U targetUnit) {
        if (other == null) throw new IllegalArgumentException("Other quantity is null");
        if (targetUnit == null) throw new IllegalArgumentException("Target unit is null");

        if (!unit.getClass().equals(other.unit.getClass())) {
            throw new IllegalArgumentException("Cross-category operation not allowed");
        }

        if (!Double.isFinite(other.value)) {
            throw new IllegalArgumentException("Invalid value in other quantity");
        }
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}