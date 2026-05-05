public class QuantityMeasurementApp {
    public static void main(String[] args) {
        Quantity<VolumeUnit> litre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> millilitre = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> gallon = new Quantity<>(1.0, VolumeUnit.GALLON);

        // Equality
        System.out.println("Equality:");
        System.out.println(litre.equals(millilitre)); // true
        System.out.println(litre.equals(gallon));     // true

        // Conversion
        System.out.println("\nConversion:");
        System.out.println(litre.convertTo(VolumeUnit.MILLILITRE)); // 1000.0 mL
        System.out.println(gallon.convertTo(VolumeUnit.LITRE));     // 3.78541 L

        // Addition
        System.out.println("\nAddition:");
        System.out.println(litre.add(millilitre)); // 2.0 L
        System.out.println(litre.add(gallon, VolumeUnit.MILLILITRE)); // 4785.41 mL
    }
}
