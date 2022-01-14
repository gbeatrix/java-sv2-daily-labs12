package day05;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StringStatisticsTest {
    @Test
    void testStringStatistics() {
        String text = "árvíztűrő tükörfúrógép";
        Map<Character, Integer> stat = StringStatistics.calcStat(text);
        assertEquals(4, stat.get('r'));
        assertEquals(1, stat.get('ő'));
        int sum = 0;
        for (int x : stat.values()) {
            sum += x;
        }
        assertEquals(text.length(), sum);
    }

    @Test
    void testInvalid() {
        assertThrows(IllegalArgumentException.class,
                () -> StringStatistics.calcStat(null));
    }
}