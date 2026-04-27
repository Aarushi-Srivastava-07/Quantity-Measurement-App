public class QuantityMeasurementAppTest {

    public static void main(String[] args) {
        Length feet1 = new Length(1.0, Length.LengthUnit.FEET);
        Length feet2 = new Length(2.0, Length.LengthUnit.FEET);
        Length inches12 = new Length(12.0, Length.LengthUnit.INCHES);
        Length inches36 = new Length(36.0, Length.LengthUnit.INCHES);
        Length yard1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length cm2_54 = new Length(2.54, Length.LengthUnit.CENTIMETERS);
        Length inch1 = new Length(1.0, Length.LengthUnit.INCHES);

        System.out.println("Same Unit Feet+Feet: " +
                (feet1.add(feet2).equals(new Length(3.0, Length.LengthUnit.FEET)) ? "PASS" : "FAIL"));

        System.out.println("Same Unit Inch+Inch: " +
                (inches12.add(inches12).equals(new Length(24.0, Length.LengthUnit.INCHES)) ? "PASS" : "FAIL"));

        System.out.println("Cross Unit Feet+Inches: " +
                (feet1.add(inches12).equals(new Length(2.0, Length.LengthUnit.FEET)) ? "PASS" : "FAIL"));

        System.out.println("Cross Unit Inches+Feet: " +
                (inches12.add(feet1).equals(new Length(24.0, Length.LengthUnit.INCHES)) ? "PASS" : "FAIL"));

        System.out.println("Cross Unit Yard+Feet: " +
                (yard1.add(feet2).equals(new Length(2.0, Length.LengthUnit.YARDS)) ? "PASS" : "FAIL"));

        System.out.println("Cross Unit Inches+Yard: " +
                (inches36.add(yard1).equals(new Length(72.0, Length.LengthUnit.INCHES)) ? "PASS" : "FAIL"));

        System.out.println("Cross Unit Cm+Inch: " +
                (cm2_54.add(inch1).equals(new Length(5.08, Length.LengthUnit.CENTIMETERS)) ? "PASS" : "FAIL"));

        System.out.println("Commutativity Feet+Inches vs Inches+Feet: " +
                (feet1.add(inches12).equals(inches12.add(feet1)) ? "PASS" : "FAIL"));

        System.out.println("Identity Element Feet+ZeroInches: " +
                (new Length(5.0, Length.LengthUnit.FEET).add(new Length(0.0, Length.LengthUnit.INCHES))
                        .equals(new Length(5.0, Length.LengthUnit.FEET)) ? "PASS" : "FAIL"));

        System.out.println("Negative Values Feet+(-Feet): " +
                (new Length(5.0, Length.LengthUnit.FEET).add(new Length(-2.0, Length.LengthUnit.FEET))
                        .equals(new Length(3.0, Length.LengthUnit.FEET)) ? "PASS" : "FAIL"));

        System.out.println("Large Values: " +
                (new Length(1e6, Length.LengthUnit.FEET).add(new Length(1e6, Length.LengthUnit.FEET))
                        .equals(new Length(2e6, Length.LengthUnit.FEET)) ? "PASS" : "FAIL"));

        System.out.println("Small Values: " +
                (new Length(0.001, Length.LengthUnit.FEET).add(new Length(0.002, Length.LengthUnit.FEET))
                        .equals(new Length(0.003, Length.LengthUnit.FEET)) ? "PASS" : "FAIL"));
    }
}
