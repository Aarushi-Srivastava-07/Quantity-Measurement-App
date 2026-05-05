

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testLengthEquality() {
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCHES);
        assertTrue(feet.equals(inches));
    }

    @Test
    void testWeightEquality() {
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> grams = new Quantity<>(1000.0, WeightUnit.GRAM);
        assertTrue(kg.equals(grams));
    }

    @Test
    void testLengthConversion() {
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = feet.convertTo(LengthUnit.INCHES);
        assertEquals(12.0, inches.getValue());
    }

    @Test
    void testWeightConversion() {
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> grams = kg.convertTo(WeightUnit.GRAM);
        assertEquals(1000.0, grams.getValue());
    }

    @Test
    void testLengthAddition() {
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> result = feet.add(inches, LengthUnit.FEET);
        assertEquals(2.0, result.getValue());
    }

    @Test
    void testWeightAddition() {
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> grams = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> result = kg.add(grams, WeightUnit.KILOGRAM);
        assertEquals(2.0, result.getValue());
    }

    @Test
    void testCrossCategoryEquality() {
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        assertFalse(feet.equals(kg));
    }

    @Test
    void testInvalidConstructor_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> new Quantity<>(1.0, null));
    }

    @Test
    void testInvalidConstructor_NaNValue() {
        assertThrows(IllegalArgumentException.class, () -> new Quantity<>(Double.NaN, LengthUnit.FEET));
    }
}
