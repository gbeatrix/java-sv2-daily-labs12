package day02;

public class MathAlgorithms {
    public int greatestCommonDivisor(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == b && a == 0) {
            throw new ArithmeticException("Invalid parameters");
        } else if (a > b) {
            return greatestCommonDivisor(b, a);
        } else if (a == 0) {
            return b;
        } else {
            return greatestCommonDivisor(b % a, a);
        }
    }
}
