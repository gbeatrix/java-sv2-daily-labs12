package day04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {
    @Test
    void testProgram() {
        Program program = new Program();
        program.readFile(Path.of("src/main/resources/beosztas.txt"));
        assertEquals(7, program.getItemsByTeacher("Bagoly Barbara").size());
        assertEquals(25, program.getWeeklyHoursByTeacher("Bagoly Barbara"));
    }
}