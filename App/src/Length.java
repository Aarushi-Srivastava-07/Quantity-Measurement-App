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

    private boolean compare(Length other) {
        return Double.compare(this.convertToBaseUnit(), other.convertToBaseUnit()) == 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Length other = (Length) obj;
        return compare(other);
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

    public static double convert(double value, LengthUnit source, LengthUnit target) {
        if (source == null || target == null) throw new IllegalArgumentException("Units cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Value must be finite");
        double baseValue = value * source.getConversionFactor();
        double converted = baseValue / target.getConversionFactor();
        return Math.round(converted * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}
