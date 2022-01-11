package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathAlgorithmsTest {
    @Test
    void testGcd(){
        MathAlgorithms calc = new MathAlgorithms();
        assertEquals(3, calc.greatestCommonDivisor(-12, 15));
        assertEquals(13, calc.greatestCommonDivisor(65, 39));
        assertEquals(25, calc.greatestCommonDivisor(100, 175));

        assertThrows(ArithmeticException.class,
                () -> calc.greatestCommonDivisor(0, 0));
        assertEquals(73, calc.greatestCommonDivisor(73, 0));
    }
}