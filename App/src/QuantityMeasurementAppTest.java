import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testAdd_SameUnit() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);
        assertEquals("Quantity(2.0, FEET)", q1.add(q2).toString());
    }

    @Test
    void testAdd_ExplicitTarget() {
        Quantity<WeightUnit> q1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> q2 = new Quantity<>(5000.0, WeightUnit.GRAM);
        assertEquals("Quantity(15000.0, GRAM)", q1.add(q2, WeightUnit.GRAM).toString());
    }

    @Test
    void testSubtract_CrossUnit() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(6.0, LengthUnit.INCHES);
        assertEquals("Quantity(9.5, FEET)", q1.subtract(q2).toString());
    }

    @Test
    void testSubtract_ExplicitTarget() {
        Quantity<VolumeUnit> q1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> q2 = new Quantity<>(2.0, VolumeUnit.LITRE);
        assertEquals("Quantity(3000.0, MILLILITRE)", q1.subtract(q2, VolumeUnit.MILLILITRE).toString());
    }

    @Test
    void testDivide_SameUnit() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);
        assertEquals(5.0, q1.divide(q2));
    }

    @Test
    void testDivide_CrossUnit() {
        Quantity<LengthUnit> q1 = new Quantity<>(24.0, LengthUnit.INCHES);
        Quantity<LengthUnit> q2 = new Quantity<>(2.0, LengthUnit.FEET);
        assertEquals(1.0, q1.divide(q2));
    }

    @Test
    void testDivide_ByZero() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(0.0, LengthUnit.FEET);
        assertThrows(ArithmeticException.class, () -> q1.divide(q2));
    }

    @Test
    void testValidation_NullOperand_AllOps() {
        Quantity<LengthUnit> q = new Quantity<>(10.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> q.add(null));
        assertThrows(IllegalArgumentException.class, () -> q.subtract(null));
        assertThrows(IllegalArgumentException.class, () -> q.divide(null));
    }

    @Test
    void testValidation_CrossCategory_AllOps() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<WeightUnit> q2 = new Quantity<>(5.0, WeightUnit.KILOGRAM);
        assertThrows(IllegalArgumentException.class, () -> q1.add((Quantity) q2));
        assertThrows(IllegalArgumentException.class, () -> q1.subtract((Quantity) q2));
        assertThrows(IllegalArgumentException.class, () -> q1.divide((Quantity) q2));
    }

    @Test
    void testImmutability_AllOps() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5.0, LengthUnit.FEET);
        q1.add(q2);
        q1.subtract(q2);
        q1.divide(q2);
        assertEquals("Quantity(10.0, FEET)", q1.toString());
    }

    @Test
    void testNonCommutative_Subtract() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5.0, LengthUnit.FEET);
        assertNotEquals(q1.subtract(q2).toString(), q2.subtract(q1).toString());
    }

    @Test
    void testNonCommutative_Divide() {
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5.0, LengthUnit.FEET);
        assertNotEquals(q1.divide(q2), q2.divide(q1));
    }

    @Test
    void testRounding_Subtraction() {
        Quantity<LengthUnit> q1 = new Quantity<>(1.555, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(0.555, LengthUnit.FEET);
        assertEquals("Quantity(1.0, FEET)", q1.subtract(q2).toString());
    }

    @Test
    void testChainOperations() {
        Quantity<LengthUnit> q = new Quantity<>(10.0, LengthUnit.FEET)
                .add(new Quantity<>(2.0, LengthUnit.FEET))
                .subtract(new Quantity<>(1.0, LengthUnit.FEET));
        assertEquals("Quantity(11.0, FEET)", q.toString());
    }
}