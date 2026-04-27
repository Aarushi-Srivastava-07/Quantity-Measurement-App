

/**
 * Represents a weight quantity with support for equality, conversion, and addition.
 */
public class Weight {
    private final double value;
    private final WeightUnit unit;

    public Weight(double value, WeightUnit unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Value must be finite");
        this.value = value;
        this.unit = unit;
    }

    private double convertToBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    private double convertFromBaseToTargetUnit(double baseValue, WeightUnit targetUnit) {
        return targetUnit.convertFromBaseUnit(baseValue);
    }

    public Weight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
        double baseValue = convertToBaseUnit();
        double converted = convertFromBaseToTargetUnit(baseValue, targetUnit);
        return new Weight(converted, targetUnit);
    }

    public Weight add(Weight thatWeight) {
        if (thatWeight == null) throw new IllegalArgumentException("Operand cannot be null");
        double sumInBase = this.convertToBaseUnit() + thatWeight.convertToBaseUnit();
        double resultValue = convertFromBaseToTargetUnit(sumInBase, this.unit);
        return new Weight(resultValue, this.unit);
    }

    public Weight add(Weight thatWeight, WeightUnit targetUnit) {
        if (thatWeight == null) throw new IllegalArgumentException("Operand cannot be null");
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
        double sumInBase = this.convertToBaseUnit() + thatWeight.convertToBaseUnit();
        double resultValue = convertFromBaseToTargetUnit(sumInBase, targetUnit);
        return new Weight(resultValue, targetUnit);
    }

    private boolean compare(Weight thatWeight) {
        return Math.abs(this.convertToBaseUnit() - thatWeight.convertToBaseUnit()) < 1e-6;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weight)) return false;
        Weight other = (Weight) o;
        return compare(other);
    }

    @Override
    public int hashCode() {
        return Double.hashCode(convertToBaseUnit());
    }

    @Override
    public String toString() {
        return String.format("%.6f %s", value, unit);
    }
}
