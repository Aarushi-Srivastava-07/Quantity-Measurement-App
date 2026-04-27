public class QuantityMeasurementApp {

    public static class Length {
        private final double value;
        private final LengthUnit unit;

        public enum LengthUnit {
            FEET(12.0),
            INCHES(1.0),
            YARDS(36.0),
            CENTIMETERS(0.393701);

            private final double conversionFactor;
            LengthUnit(double conversionFactor) { this.conversionFactor = conversionFactor; }
            public double getConversionFactor() { return conversionFactor; }
        }

        public Length(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        private double convertToBaseUnit() {
            return value * unit.getConversionFactor();
        }

        public boolean compare(Length other) {
            return Double.compare(this.convertToBaseUnit(), other.convertToBaseUnit()) == 0;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            Length other = (Length) obj;
            return compare(other);
        }

        @Override
        public int hashCode() {
            return Double.hashCode(convertToBaseUnit());
        }
    }

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static void demonstrateLengthComparison(double v1, Length.LengthUnit u1, double v2, Length.LengthUnit u2) {
        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);
        System.out.println("Comparing " + v1 + " " + u1 + " with " + v2 + " " + u2 + ": " + l1.equals(l2));
    }

    public static void main(String[] args) {
        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET, 12.0, Length.LengthUnit.INCHES);
        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS, 36.0, Length.LengthUnit.INCHES);
        demonstrateLengthComparison(100.0, Length.LengthUnit.CENTIMETERS, 39.3701, Length.LengthUnit.INCHES);
        demonstrateLengthComparison(3.0, Length.LengthUnit.FEET, 1.0, Length.LengthUnit.YARDS);
        demonstrateLengthComparison(38.48, Length.LengthUnit.CENTIMETERS, 1.0, Length.LengthUnit.FEET);
    }
}
