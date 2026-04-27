public class QuantityMeasurementAppTest {

    public static void main(String[] args) {
        QuantityMeasurementApp.Length l1 = new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.Length.LengthUnit.FEET);
        QuantityMeasurementApp.Length l2 = new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.Length.LengthUnit.FEET);
        QuantityMeasurementApp.Length l3 = new QuantityMeasurementApp.Length(2.0, QuantityMeasurementApp.Length.LengthUnit.FEET);
        QuantityMeasurementApp.Length l4 = new QuantityMeasurementApp.Length(1.0, QuantityMeasurementApp.Length.LengthUnit.INCHES);
        QuantityMeasurementApp.Length l5 = new QuantityMeasurementApp.Length(12.0, QuantityMeasurementApp.Length.LengthUnit.INCHES);

        System.out.println("Feet to Feet Same Value: " + (l1.equals(l2) ? "PASS" : "FAIL"));
        System.out.println("Feet to Feet Different Value: " + (!l1.equals(l3) ? "PASS" : "FAIL"));
        System.out.println("Inch to Inch Same Value: " + (l4.equals(l4) ? "PASS" : "FAIL"));
        System.out.println("Feet to Inch Equivalent Value: " + (l1.equals(l5) ? "PASS" : "FAIL"));
        System.out.println("Null Comparison: " + (!l1.equals(null) ? "PASS" : "FAIL"));
        System.out.println("Same Reference: " + (l1.equals(l1) ? "PASS" : "FAIL"));
        System.out.println("Different Class: " + (!l1.equals("NotLength") ? "PASS" : "FAIL"));
    }
}
