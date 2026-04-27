
/**
 * QuantityLength class simplified to delegate conversion logic to LengthUnit.
 */
public class Length {
    private final double value;
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Value must be finite");
        this.value = value;
        this.unit = unit;
    }

    private double convertToBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    private double convertFromBaseToTargetUnit(double baseValue, LengthUnit targetUnit) {
        return targetUnit.convertFromBaseUnit(baseValue);
    }

    public Length convertTo(LengthUnit targetUnit) {
        double baseValue = convertToBaseUnit();
        double converted = convertFromBaseToTargetUnit(baseValue, targetUnit);
        return new Length(converted, targetUnit);
    }

    public Length add(Length thatLength) {
        double sumInBase = this.convertToBaseUnit() + thatLength.convertToBaseUnit();
        double resultValue = convertFromBaseToTargetUnit(sumInBase, this.unit);
        return new Length(resultValue, this.unit);
    }

    public Length add(Length thatLength, LengthUnit targetUnit) {
        double sumInBase = this.convertToBaseUnit() + thatLength.convertToBaseUnit();
        double resultValue = convertFromBaseToTargetUnit(sumInBase, targetUnit);
        return new Length(resultValue, targetUnit);
    }

    private boolean compare(Length thatLength) {
        return Double.compare(this.convertToBaseUnit(), thatLength.convertToBaseUnit()) == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Length)) return false;
        Length other = (Length) o;
        return compare(other);
    }

    @Override
    public int hashCode() {
        return Double.hashCode(convertToBaseUnit());
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}
