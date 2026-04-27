public class QuantityMeasurementAppTest {

    public static void main(String[] args) {
        Length feet1 = new Length(1.0, Length.LengthUnit.FEET);
        Length inches12 = new Length(12.0, Length.LengthUnit.INCHES);
        Length yard1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length cm2_54 = new Length(2.54, Length.LengthUnit.CENTIMETERS);

        System.out.println("Explicit Target Unit FEET: " +
                (feet1.add(inches12, Length.LengthUnit.FEET)
                        .equals(new Length(2.0, Length.LengthUnit.FEET)) ? "PASS" : "FAIL"));

        System.out.println("Explicit Target Unit INCHES: " +
                (feet1.add(inches12, Length.LengthUnit.INCHES)
                        .equals(new Length(24.0, Length.LengthUnit.INCHES)) ? "PASS" : "FAIL"));

        System.out.println("Explicit Target Unit YARDS: " +
                (feet1.add(inches12, Length.LengthUnit.YARDS)
                        .equals(new Length(0.67, Length.LengthUnit.YARDS)) ? "PASS" : "FAIL"));

        System.out.println("Explicit Target Unit CENTIMETERS: " +
                (new Length(1.0, Length.LengthUnit.INCHES)
                        .add(new Length(1.0, Length.LengthUnit.INCHES), Length.LengthUnit.CENTIMETERS)
                        .equals(new Length(5.08, Length.LengthUnit.CENTIMETERS)) ? "PASS" : "FAIL"));

        System.out.println("Same as First Operand (YARDS): " +
                (new Length(2.0, Length.LengthUnit.YARDS)
                        .add(new Length(3.0, Length.LengthUnit.FEET), Length.LengthUnit.YARDS)
                        .equals(new Length(3.0, Length.LengthUnit.YARDS)) ? "PASS" : "FAIL"));

        System.out.println("Same as Second Operand (FEET): " +
                (new Length(2.0, Length.LengthUnit.YARDS)
                        .add(new Length(3.0, Length.LengthUnit.FEET), Length.LengthUnit.FEET)
                        .equals(new Length(9.0, Length.LengthUnit.FEET)) ? "PASS" : "FAIL"));

        System.out.println("Commutativity with Target Unit YARDS: " +
                (feet1.add(inches12, Length.LengthUnit.YARDS)
                        .equals(inches12.add(feet1, Length.LengthUnit.YARDS)) ? "PASS" : "FAIL"));

        System.out.println("Zero Operand with Target Unit YARDS: " +
                (new Length(5.0, Length.LengthUnit.FEET)
                        .add(new Length(0.0, Length.LengthUnit.INCHES), Length.LengthUnit.YARDS)
                        .equals(new Length(1.67, Length.LengthUnit.YARDS)) ? "PASS" : "FAIL"));

        System.out.println("Negative Operand with Target Unit INCHES: " +
                (new Length(5.0, Length.LengthUnit.FEET)
                        .add(new Length(-2.0, Length.LengthUnit.FEET), Length.LengthUnit.INCHES)
                        .equals(new Length(36.0, Length.LengthUnit.INCHES)) ? "PASS" : "FAIL"));

        System.out.println("Large to Small Scale (INCHES): " +
                (new Length(1000.0, Length.LengthUnit.FEET)
                        .add(new Length(500.0, Length.LengthUnit.FEET), Length.LengthUnit.INCHES)
                        .equals(new Length(18000.0, Length.LengthUnit.INCHES)) ? "PASS" : "FAIL"));

        System.out.println("Small to Large Scale (YARDS): " +
                (new Length(12.0, Length.LengthUnit.INCHES)
                        .add(new Length(12.0, Length.LengthUnit.INCHES), Length.LengthUnit.YARDS)
                        .equals(new Length(0.67, Length.LengthUnit.YARDS)) ? "PASS" : "FAIL"));
    }
}
