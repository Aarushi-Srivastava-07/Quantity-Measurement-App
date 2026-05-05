import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testEquality_LitreToMillilitre() {
        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> millilitre = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        assertTrue(litre.equals(millilitre));
    }

    @Test
    void testEquality_LitreToGallon() {
        Quantity<VolumeUnit> litre = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> gallon = new Quantity<>(1.0, VolumeUnit.GALLON);
        assertTrue(litre.equals(gallon));
    }

    @Test
    void testConversion_LitreToMillilitre() {
        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = litre.convertTo(VolumeUnit.MILLILITRE);
        assertEquals(1000.0, result.getValue(), 1e-6);
    }

    @Test
    void testConversion_GallonToLitre() {
        Quantity<VolumeUnit> gallon = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> result = gallon.convertTo(VolumeUnit.LITRE);
        assertEquals(3.78541, result.getValue(), 1e-6);
    }

    @Test
    void testAddition_LitrePlusMillilitre() {
        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> millilitre = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> result = litre.add(millilitre);
        assertEquals(2.0, result.getValue(), 1e-6);
        assertEquals(VolumeUnit.LITRE, result.getUnit());
    }

    @Test
    void testAddition_ExplicitTargetUnit() {
        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> gallon = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> result = litre.add(gallon, VolumeUnit.MILLILITRE);
        assertEquals(4785.41, result.getValue(), 1e-2); // tolerance for floating point
        assertEquals(VolumeUnit.MILLILITRE, result.getUnit());
    }

    @Test
    void testCategoryIncompatibility() {
        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<LengthUnit> foot = new Quantity<>(1.0, LengthUnit.FOOT);
        assertFalse(litre.equals(foot));
    }

    @Test
    void testNegativeValues() {
        Quantity<VolumeUnit> litre = new Quantity<>(-1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> millilitre = new Quantity<>(-1000.0, VolumeUnit.MILLILITRE);
        assertTrue(litre.equals(millilitre));
    }

    @Test
    void testZeroValues() {
        Quantity<VolumeUnit> litre = new Quantity<>(0.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> millilitre = new Quantity<>(0.0, VolumeUnit.MILLILITRE);
        assertTrue(litre.equals(millilitre));
    }
}
