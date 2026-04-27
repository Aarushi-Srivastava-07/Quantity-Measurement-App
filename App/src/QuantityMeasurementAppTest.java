
public class QuantityMeasurementAppTest {

    public static void main(String[] args) {
        System.out.println("Feet to Inches: " + (Length.convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES) == 12.0 ? "PASS" : "FAIL"));
        System.out.println("Inches to Feet: " + (Length.convert(24.0, Length.LengthUnit.INCHES, Length.LengthUnit.FEET) == 2.0 ? "PASS" : "FAIL"));
        System.out.println("Yards to Inches: " + (Length.convert(1.0, Length.LengthUnit.YARDS, Length.LengthUnit.INCHES) == 36.0 ? "PASS" : "FAIL"));
        System.out.println("Inches to Yards: " + (Length.convert(72.0, Length.LengthUnit.INCHES, Length.LengthUnit.YARDS) == 2.0 ? "PASS" : "FAIL"));
        System.out.println("Centimeters to Inches: " + (Math.abs(Length.convert(2.54, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES) - 1.0) < 1e-6 ? "PASS" : "FAIL"));
        System.out.println("Feet to Yards: " + (Length.convert(6.0, Length.LengthUnit.FEET, Length.LengthUnit.YARDS) == 2.0 ? "PASS" : "FAIL"));
        System.out.println("Zero Value: " + (Length.convert(0.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES) == 0.0 ? "PASS" : "FAIL"));
        System.out.println("Negative Value: " + (Length.convert(-1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES) == -12.0 ? "PASS" : "FAIL"));
        System.out.println("Round Trip: " + (Math.abs(Length.convert(Length.convert(5.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES), Length.LengthUnit.INCHES, Length.LengthUnit.FEET) - 5.0) < 1e-6 ? "PASS" : "FAIL"));
    }
}
