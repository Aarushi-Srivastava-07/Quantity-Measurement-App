public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(6.0, LengthUnit.INCHES);

        System.out.println(l1.add(l2));
        System.out.println(l1.subtract(l2));
        System.out.println(l1.subtract(l2, LengthUnit.INCHES));
        System.out.println(l1.divide(l2));

        Quantity<WeightUnit> w1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(5000.0, WeightUnit.GRAM);

        System.out.println(w1.add(w2));
        System.out.println(w1.subtract(w2));
        System.out.println(w1.divide(w2));

        Quantity<VolumeUnit> v1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(2.0, VolumeUnit.LITRE);

        System.out.println(v1.add(v2));
        System.out.println(v1.subtract(v2, VolumeUnit.MILLILITRE));
        System.out.println(v1.divide(v2));
    }
}