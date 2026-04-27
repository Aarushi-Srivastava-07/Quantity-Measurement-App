public class QuantityMeasurementAppTest {

    public static void main(String[] args) {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet f3 = new QuantityMeasurementApp.Feet(2.0);

        System.out.println("Feet Same Value: " + (f1.equals(f2) ? "PASS" : "FAIL"));
        System.out.println("Feet Different Value: " + (!f1.equals(f3) ? "PASS" : "FAIL"));
        System.out.println("Feet Null Comparison: " + (!f1.equals(null) ? "PASS" : "FAIL"));
        System.out.println("Feet Different Class: " + (!f1.equals("NotFeet") ? "PASS" : "FAIL"));
        System.out.println("Feet Same Reference: " + (f1.equals(f1) ? "PASS" : "FAIL"));

        QuantityMeasurementApp.Inches i1 = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches i2 = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches i3 = new QuantityMeasurementApp.Inches(2.0);

        System.out.println("Inches Same Value: " + (i1.equals(i2) ? "PASS" : "FAIL"));
        System.out.println("Inches Different Value: " + (!i1.equals(i3) ? "PASS" : "FAIL"));
        System.out.println("Inches Null Comparison: " + (!i1.equals(null) ? "PASS" : "FAIL"));
        System.out.println("Inches Different Class: " + (!i1.equals("NotInches") ? "PASS" : "FAIL"));
        System.out.println("Inches Same Reference: " + (i1.equals(i1) ? "PASS" : "FAIL"));
    }
}
