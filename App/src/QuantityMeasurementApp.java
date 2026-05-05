

public class QuantityMeasurementApp {

    public static <U extends IMeasurable> void demonstrateEquality(Quantity<U> q1, Quantity<U> q2) {
        System.out.println("Equality: " + q1 + " == " + q2 + " ? " + q1.equals(q2));
    }

    public static <U extends IMeasurable> void demonstrateConversion(Quantity<U> q, U targetUnit) {
        System.out.println("Conversion: " + q + " -> " + q.convertTo(targetUnit));
    }

    public static <U extends IMeasurable> void demonstrateAddition(Quantity<U> q1, Quantity<U> q2, U targetUnit) {
        System.out.println("Addition: " + q1 + " + " + q2 + " -> " + q1.add(q2, targetUnit));
    }

    public static void main(String[] args) {
        // Length examples
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCHES);
        demonstrateEquality(feet, inches);
        demonstrateConversion(feet, LengthUnit.INCHES);
        demonstrateAddition(feet, inches, LengthUnit.FEET);

        // Weight examples
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> grams = new Quantity<>(1000.0, WeightUnit.GRAM);
        demonstrateEquality(kg, grams);
        demonstrateConversion(kg, WeightUnit.GRAM);
        demonstrateAddition(kg, grams, WeightUnit.KILOGRAM);

        // Cross-category prevention
        Quantity<WeightUnit> pounds = new Quantity<>(2.0, WeightUnit.POUND);
        System.out.println("Cross-category equals: " + feet.equals(pounds)); // false
    }
}
