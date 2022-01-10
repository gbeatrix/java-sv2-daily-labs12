package day01;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.time.Month;
import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class RunningTest {
    @Test
    void testReadFile() {
        Running running = new Running();
        running.readData(Path.of("src/test/resources/running.csv"));
        assertEquals(145, running.getValues().length());
    }

    @Test
    void testReadFileError() {
        Running running = new Running();
        Path path = Path.of("src/resources/running.csv");
        assertThrows(IllegalStateException.class,
                () -> running.readData(path));
    }

    @Test
    void testSum() {
        Running running = new Running();
        running.readData(Path.of("src/test/resources/running.csv"));
        double sum = running.sum(Year.of(2022), Month.JANUARY);
        assertEquals(25.9, sum, 1e-5);
    }
}