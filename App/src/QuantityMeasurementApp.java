import java.util.Scanner;

public class QuantityMeasurementApp {

    // Inner class to represent Feet measurement
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;

            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first value in feet: ");
        double firstValue = scanner.nextDouble();

        System.out.print("Enter second value in feet: ");
        double secondValue = scanner.nextDouble();

        Feet feet1 = new Feet(firstValue);
        Feet feet2 = new Feet(secondValue);

        boolean result = feet1.equals(feet2);
        System.out.println("Are the two values equal? " + result);

        scanner.close();
    }
}
