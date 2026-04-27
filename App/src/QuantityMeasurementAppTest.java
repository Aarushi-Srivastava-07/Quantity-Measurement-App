public class QuantityMeasurementAppTest {

    public static void main(String[] args) {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet3 = new QuantityMeasurementApp.Feet(2.0);

        System.out.println("Test Same Value: " + (feet1.equals(feet2) ? "PASS" : "FAIL"));
        System.out.println("Test Different Value: " + (!feet1.equals(feet3) ? "PASS" : "FAIL"));
        System.out.println("Test Null Comparison: " + (!feet1.equals(null) ? "PASS" : "FAIL"));
        System.out.println("Test Different Class: " + (!feet1.equals("NotFeet") ? "PASS" : "FAIL"));
        System.out.println("Test Same Reference: " + (feet1.equals(feet1) ? "PASS" : "FAIL"));
    }
}
