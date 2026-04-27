
public class QuantityMeasurementAppTest {

    private static boolean approxEqual(double a, double b) {
        return Math.abs(a - b) < 1e-6;
    }

    public static void main(String[] args) {
        // Enum constants and conversion factors
        System.out.println("LengthUnit FEET factor: " +
                (LengthUnit.FEET.getConversionFactor() == 12.0 ? "PASS" : "FAIL"));
        System.out.println("LengthUnit INCHES factor: " +
                (LengthUnit.INCHES.getConversionFactor() == 1.0 ? "PASS" : "FAIL"));
        System.out.println("LengthUnit YARDS factor: " +
                (LengthUnit.YARDS.getConversionFactor() == 36.0 ? "PASS" : "FAIL"));
        System.out.println("LengthUnit CENTIMETERS factor: " +
                (approxEqual(LengthUnit.CENTIMETERS.getConversionFactor(), 0.393701) ? "PASS" : "FAIL"));

        // Base unit conversions
        System.out.println("Feet to base: " +
                (LengthUnit.FEET.convertToBaseUnit(1.0) == 12.0 ? "PASS" : "FAIL"));
        System.out.println("Inches to base: " +
                (LengthUnit.INCHES.convertToBaseUnit(12.0) == 12.0 ? "PASS" : "FAIL"));
        System.out.println("Yards to base: " +
                (LengthUnit.YARDS.convertToBaseUnit(1.0) == 36.0 ? "PASS" : "FAIL"));
        System.out.println("Centimeters to base: " +
                (approxEqual(LengthUnit.CENTIMETERS.convertToBaseUnit(2.54), 1.0) ? "PASS" : "FAIL"));

        // From base conversions
        System.out.println("Base to feet: " +
                (LengthUnit.FEET.convertFromBaseUnit(12.0) == 1.0 ? "PASS" : "FAIL"));
        System.out.println("Base to inches: " +
                (LengthUnit.INCHES.convertFromBaseUnit(12.0) == 12.0 ? "PASS" : "FAIL"));
        System.out.println("Base to yards: " +
                (LengthUnit.YARDS.convertFromBaseUnit(36.0) == 1.0 ? "PASS" : "FAIL"));
        System.out.println("Base to cm: " +
                (approxEqual(LengthUnit.CENTIMETERS.convertFromBaseUnit(1.0), 2.54) ? "PASS" : "FAIL"));

        // Equality
        System.out.println("Equality feet vs inches: " +
                (new Length(1.0, LengthUnit.FEET).equals(new Length(12.0, LengthUnit.INCHES)) ? "PASS" : "FAIL"));

        // Conversion
        System.out.println("Convert feet to inches: " +
                (new Length(1.0, LengthUnit.FEET).convertTo(LengthUnit.INCHES)
                        .equals(new Length(12.0, LengthUnit.INCHES)) ? "PASS" : "FAIL"));

        // Addition
        System.out.println("Add feet + inches (target FEET): " +
                (new Length(1.0, LengthUnit.FEET).add(new Length(12.0, LengthUnit.INCHES), LengthUnit.FEET)
                        .equals(new Length(2.0, LengthUnit.FEET)) ? "PASS" : "FAIL"));

        System.out.println("Add feet + inches (target YARDS): " +
                (new Length(1.0, LengthUnit.FEET).add(new Length(12.0, LengthUnit.INCHES), LengthUnit.YARDS)
                        .equals(new Length(0.67, LengthUnit.YARDS)) ? "PASS" : "FAIL"));

        // Edge cases
        try {
            new Length(1.0, null);
            System.out.println("Null unit: FAIL");
        } catch (IllegalArgumentException e) {
            System.out.println("Null unit: PASS");
        }

        try {
            new Length(Double.NaN, LengthUnit.FEET);
            System.out.println("NaN value: FAIL");
        } catch (IllegalArgumentException e) {
            System.out.println("NaN value: PASS");
        }

        // Round-trip conversion
        double original = 5.0;
        Length l = new Length(original, LengthUnit.FEET);
        Length roundTrip = l.convertTo(LengthUnit.INCHES).convertTo(LengthUnit.FEET);
        System.out.println("Round-trip conversion: " +
                (l.equals(roundTrip) ? "PASS" : "FAIL"));
    }
}
