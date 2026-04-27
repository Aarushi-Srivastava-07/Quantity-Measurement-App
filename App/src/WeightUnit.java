

/**
 * Standalone enum for weight units with conversion responsibility.
 * Base unit: KILOGRAM
 */
public enum WeightUnit {
    KILOGRAM(1.0),
    GRAM(0.001),       // 1 g = 0.001 kg
    POUND(0.453592);   // 1 lb ≈ 0.453592 kg

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    /** Convert value from this unit to base unit (kilograms). */
    public double convertToBaseUnit(double value) {
        double result = value * conversionFactor;
        return Math.round(result * 1000000.0) / 1000000.0; // keep precision
    }

    /** Convert value from base unit (kilograms) to this unit. */
    public double convertFromBaseUnit(double baseValue) {
        double result = baseValue / conversionFactor;
        return Math.round(result * 1000000.0) / 1000000.0;
    }
}
