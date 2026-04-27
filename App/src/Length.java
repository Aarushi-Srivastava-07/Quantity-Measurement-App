public class Length {
    private final double value;
    private final LengthUnit unit;

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;
        LengthUnit(double conversionFactor) { this.conversionFactor = conversionFactor; }
        public double getConversionFactor() { return conversionFactor; }
    }

    public Length(double value, LengthUnit unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Value must be finite");
        this.value = value;
        this.unit = unit;
    }

    private double convertToBaseUnit() {
        return Math.round(value * unit.getConversionFactor() * 100.0) / 100.0;
    }

    private double convertFromBaseToTargetUnit(double lengthInInches, LengthUnit targetUnit) {
        double converted = lengthInInches / targetUnit.getConversionFactor();
        return Math.round(converted * 100.0) / 100.0;
    }

    public Length add(Length thatLength) {
        if (thatLength == null) throw new IllegalArgumentException("Operand cannot be null");
        double sumInBase = this.convertToBaseUnit() + thatLength.convertToBaseUnit();
        double resultValue = convertFromBaseToTargetUnit(sumInBase, this.unit);
        return new Length(resultValue, this.unit);
    }

    public Length add(Length thatLength, LengthUnit targetUnit) {
        if (thatLength == null) throw new IllegalArgumentException("Operand cannot be null");
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
        double sumInBase = this.convertToBaseUnit() + thatLength.convertToBaseUnit();
        double resultValue = convertFromBaseToTargetUnit(sumInBase, targetUnit);
        return new Length(resultValue, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Length other = (Length) obj;
        return Double.compare(this.convertToBaseUnit(), other.convertToBaseUnit()) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(convertToBaseUnit());
    }

    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
        double baseValue = convertToBaseUnit();
        double converted = baseValue / targetUnit.getConversionFactor();
        double rounded = Math.round(converted * 100.0) / 100.0;
        return new Length(rounded, targetUnit);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}
