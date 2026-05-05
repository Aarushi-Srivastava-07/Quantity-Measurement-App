import java.util.function.DoubleBinaryOperator;

public final class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid value");
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    private enum ArithmeticOperation {
        ADD((a, b) -> a + b),
        SUBTRACT((a, b) -> a - b),
        DIVIDE((a, b) -> {
            if (b == 0.0) throw new ArithmeticException("Division by zero");
            return a / b;
        });

        private final DoubleBinaryOperator op;

        ArithmeticOperation(DoubleBinaryOperator op) {
            this.op = op;
        }

        public double compute(double a, double b) {
            return op.applyAsDouble(a, b);
        }
    }

    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        validateArithmeticOperands(other, targetUnit, true);
        double baseResult = performBaseArithmetic(other, ArithmeticOperation.ADD);
        double converted = targetUnit.fromBaseUnit(baseResult);
        return new Quantity<>(round(converted), targetUnit);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, this.unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        validateArithmeticOperands(other, targetUnit, true);
        double baseResult = performBaseArithmetic(other, ArithmeticOperation.SUBTRACT);
        double converted = targetUnit.fromBaseUnit(baseResult);
        return new Quantity<>(round(converted), targetUnit);
    }

    public double divide(Quantity<U> other) {
        validateArithmeticOperands(other, null, false);
        return performBaseArithmetic(other, ArithmeticOperation.DIVIDE);
    }

    private void validateArithmeticOperands(Quantity<U> other, U targetUnit, boolean targetRequired) {
        if (other == null) throw new IllegalArgumentException("Other quantity is null");
        if (!unit.getClass().equals(other.unit.getClass())) throw new IllegalArgumentException("Cross-category operation not allowed");
        if (!Double.isFinite(other.value)) throw new IllegalArgumentException("Invalid value");
        if (targetRequired && targetUnit == null) throw new IllegalArgumentException("Target unit is null");
    }

    private double performBaseArithmetic(Quantity<U> other, ArithmeticOperation operation) {
        double baseThis = unit.toBaseUnit(this.value);
        double baseOther = other.unit.toBaseUnit(other.value);
        return operation.compute(baseThis, baseOther);
    }

    private double round(double v) {
        return Math.round(v * 100.0) / 100.0;
    }

    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}