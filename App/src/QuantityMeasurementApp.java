
public class QuantityMeasurementApp {

    // Weight functionality
    public static boolean demonstrateWeightEquality(Weight w1, Weight w2) {
        return w1.equals(w2);
    }

    public static boolean demonstrateWeightComparison(double value1, WeightUnit unit1,
                                                      double value2, WeightUnit unit2) {
        Weight w1 = new Weight(value1, unit1);
        Weight w2 = new Weight(value2, unit2);
        return demonstrateWeightEquality(w1, w2);
    }

    public static Weight demonstrateWeightConversion(double value, WeightUnit fromUnit, WeightUnit toUnit) {
        return new Weight(value, fromUnit).convertTo(toUnit);
    }

    public static Weight demonstrateWeightConversion(Weight weight, WeightUnit toUnit) {
        return weight.convertTo(toUnit);
    }

    public static Weight demonstrateWeightAddition(Weight w1, Weight w2) {
        return w1.add(w2);
    }

    public static Weight demonstrateWeightAddition(Weight w1, Weight w2, WeightUnit targetUnit) {
        return w1.add(w2, targetUnit);
    }

    public static void main(String[] args) {
        // Equality
        System.out.println(new Weight(1.0, WeightUnit.KILOGRAM)
                .equals(new Weight(1000.0, WeightUnit.GRAM))); // true
        System.out.println(new Weight(1.0, WeightUnit.KILOGRAM)
                .equals(new Weight(2.20462, WeightUnit.POUND))); // true (approx)

        // Conversion
        System.out.println(demonstrateWeightConversion(1.0, WeightUnit.KILOGRAM, WeightUnit.GRAM)); // 1000 g
        System.out.println(demonstrateWeightConversion(2.20462, WeightUnit.POUND, WeightUnit.KILOGRAM)); // ~1 kg

        // Addition
        System.out.println(demonstrateWeightAddition(
                new Weight(1.0, WeightUnit.KILOGRAM),
                new Weight(1000.0, WeightUnit.GRAM))); // 2.0 KILOGRAM

        System.out.println(demonstrateWeightAddition(
                new Weight(1.0, WeightUnit.KILOGRAM),
                new Weight(1000.0, WeightUnit.GRAM),
                WeightUnit.GRAM)); // 2000.0 GRAM
    }
}
