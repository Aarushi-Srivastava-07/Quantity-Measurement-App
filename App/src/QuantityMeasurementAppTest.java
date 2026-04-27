
public class QuantityMeasurementAppTest {

    private static boolean approxEqual(double a, double b) {
        return Math.abs(a - b) < 1e-6;
    }

    public static void main(String[] args) {
        System.out.println("Equality kg==kg: " +
                (new Weight(1.0, WeightUnit.KILOGRAM).equals(new Weight(1.0, WeightUnit.KILOGRAM)) ? "PASS" : "FAIL"));

        System.out.println("Equality kg!=kg: " +
                (!new Weight(1.0, WeightUnit.KILOGRAM).equals(new Weight(2.0, WeightUnit.KILOGRAM)) ? "PASS" : "FAIL"));

        System.out.println("Equality kg==g: " +
                (new Weight(1.0, WeightUnit.KILOGRAM).equals(new Weight(1000.0, WeightUnit.GRAM)) ? "PASS" : "FAIL"));

        System.out.println("Equality g==kg: " +
                (new Weight(1000.0, WeightUnit.GRAM).equals(new Weight(1.0, WeightUnit.KILOGRAM)) ? "PASS" : "FAIL"));

        System.out.println("Equality kg==lb: " +
                (new Weight(1.0, WeightUnit.KILOGRAM).equals(new Weight(2.20462, WeightUnit.POUND)) ? "PASS" : "FAIL"));

        System.out.println("Conversion kg->g: " +
                (new Weight(1.0, WeightUnit.KILOGRAM).convertTo(WeightUnit.GRAM)
                        .equals(new Weight(1000.0, WeightUnit.GRAM)) ? "PASS" : "FAIL"));

        System.out.println("Conversion lb->kg: " +
                (new Weight(2.20462, WeightUnit.POUND).convertTo(WeightUnit.KILOGRAM)
                        .equals(new Weight(1.0, WeightUnit.KILOGRAM)) ? "PASS" : "FAIL"));

        System.out.println("Addition kg+kg: " +
                (new Weight(1.0, WeightUnit.KILOGRAM).add(new Weight(2.0, WeightUnit.KILOGRAM))
                        .equals(new Weight(3.0, WeightUnit.KILOGRAM)) ? "PASS" : "FAIL"));

        System.out.println("Addition kg+g: " +
                (new Weight(1.0, WeightUnit.KILOGRAM).add(new Weight(1000.0, WeightUnit.GRAM))
                        .equals(new Weight(2.0, WeightUnit.KILOGRAM)) ? "PASS" : "FAIL"));

        System.out.println("Addition kg+g target g: " +
                (new Weight(1.0, WeightUnit.KILOGRAM).add(new Weight(1000.0, WeightUnit.GRAM), WeightUnit.GRAM)
                        .equals(new Weight(2000.0, WeightUnit.GRAM)) ? "PASS" : "FAIL"));
    }
}
