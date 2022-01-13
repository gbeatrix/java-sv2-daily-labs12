package day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Program {
    private List<Item> items = new ArrayList<>();

    public void readFile(Path path) {
        try (BufferedReader bf = Files.newBufferedReader(path)) {
            String line;
            String teacher = "";
            String subject = "";
            String className = "";
            int weeklyHours;
            int i = 0;
            while ((line = bf.readLine()) != null) {
                switch (i++ % 4) {
                    case 0:
                        teacher = line;
                        break;
                    case 1:
                        subject = line;
                        break;
                    case 2:
                        className = line;
                        break;
                    case 3:
                    default:
                        weeklyHours = Integer.parseInt(line);
                        items.add(new Item(teacher, subject, className, weeklyHours));
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("File not found", e);
        }
    }

    public int getWeeklyHoursByTeacher(String teacher) {
        List<Item> itemsByTeacher = getItemsByTeacher(teacher);
        int sum = 0;
        for (Item item : itemsByTeacher) {
            sum += item.weeklyHours;
        }
        return sum;
    }

    public List<Item> getItemsByTeacher(String teacher) {
        List<Item> result = new LinkedList<>();
        for (Item item : items) {
            if (item.teacher.equals(teacher)) {
                result.add(item);
            }
        }
        return result;
    }

    private static class Item {
        private String teacher;
        private String subject;
        private String className;
        private int weeklyHours;

        public Item(String teacher, String subject, String className, int weeklyHours) {
            this.teacher = teacher;
            this.subject = subject;
            this.className = className;
            this.weeklyHours = weeklyHours;
        }
    }
}
