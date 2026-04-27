public class QuantityMeasurementAppTest {

    public static void main(String[] args) {
        QuantityMeasurementApp.Length yard1 = new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.Length.LengthUnit.YARDS);
        QuantityMeasurementApp.Length yard2 = new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.Length.LengthUnit.YARDS);
        QuantityMeasurementApp.Length yard3 = new QuantityMeasurementApp.Length(2.0, QuantityMeasurementApp.Length.LengthUnit.YARDS);
        QuantityMeasurementApp.Length feet3 = new QuantityMeasurementApp.Length(3.0, QuantityMeasurementApp.Length.LengthUnit.FEET);
        QuantityMeasurementApp.Length inch36 = new QuantityMeasurementApp.Length(36.0, QuantityMeasurementApp.Length.LengthUnit.INCHES);
        QuantityMeasurementApp.Length cm1 = new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.Length.LengthUnit.CENTIMETERS);
        QuantityMeasurementApp.Length inch039 = new QuantityMeasurementApp.Length(0.393701, QuantityMeasurementApp.Length.LengthUnit.INCHES);

        System.out.println("Yard to Yard Same Value: " + (yard1.equals(yard2) ? "PASS" : "FAIL"));
        System.out.println("Yard to Yard Different Value: " + (!yard1.equals(yard3) ? "PASS" : "FAIL"));
        System.out.println("Yard to Feet Equivalent Value: " + (yard1.equals(feet3) ? "PASS" : "FAIL"));
        System.out.println("Feet to Yard Equivalent Value: " + (feet3.equals(yard1) ? "PASS" : "FAIL"));
        System.out.println("Yard to Inches Equivalent Value: " + (yard1.equals(inch36) ? "PASS" : "FAIL"));
        System.out.println("Inches to Yard Equivalent Value: " + (inch36.equals(yard1) ? "PASS" : "FAIL"));
        System.out.println("Yard to Feet Non-Equivalent Value: " + (!yard1.equals(new QuantityMeasurementApp.Length(2.0, QuantityMeasurementApp.Length.LengthUnit.FEET)) ? "PASS" : "FAIL"));
        System.out.println("Centimeters to Inches Equivalent Value: " + (cm1.equals(inch039) ? "PASS" : "FAIL"));
        System.out.println("Centimeters to Feet Non-Equivalent Value: " + (!cm1.equals(feet3) ? "PASS" : "FAIL"));
        System.out.println("Multi-Unit Transitive Property: " + (yard1.equals(feet3) && feet3.equals(inch36) && yard1.equals(inch36) ? "PASS" : "FAIL"));
        System.out.println("Yard Same Reference: " + (yard1.equals(yard1) ? "PASS" : "FAIL"));
        System.out.println("Yard Null Comparison: " + (!yard1.equals(null) ? "PASS" : "FAIL"));
        System.out.println("Centimeters Same Reference: " + (cm1.equals(cm1) ? "PASS" : "FAIL"));
        System.out.println("Centimeters Null Comparison: " + (!cm1.equals(null) ? "PASS" : "FAIL"));
        System.out.println("All Units Complex Scenario: " + (new QuantityMeasurementApp.Length(2.0, QuantityMeasurementApp.Length.LengthUnit.YARDS)
                .equals(new QuantityMeasurementApp.Length(6.0, QuantityMeasurementApp.Length.LengthUnit.FEET))
                && new QuantityMeasurementApp.Length(6.0, QuantityMeasurementApp.Length.LengthUnit.FEET)
                .equals(new QuantityMeasurementApp.Length(72.0, QuantityMeasurementApp.Length.LengthUnit.INCHES)) ? "PASS" : "FAIL"));
    }
}
