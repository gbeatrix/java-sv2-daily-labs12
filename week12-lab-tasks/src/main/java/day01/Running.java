package day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Path;
import java.time.Month;
import java.time.Year;
import java.util.Scanner;

public class Running {
    private String values;

    public String getValues() {
        return values;
    }

    public void readData(Path path) {
        try (Scanner scanner = new Scanner(path)) {
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
                sb.append("\n");
            }
            values = sb.toString();
        } catch (IOException e) {
            throw new IllegalStateException("File not found", e);
        }
    }

    public double sum(Year year, Month month) {
        try (BufferedReader bufferedReader = new BufferedReader(new StringReader(values))) {
            String line;
            double sum = 0;
            boolean first = true;
            while ((line = bufferedReader.readLine()) != null) {
                if(first){
                    first = false;
                } else {
                    String[] parts = line.split("[\s;-]");
                    int yearOfRunning = Integer.parseInt(parts[2]);
                    int monthOfRunning = Integer.parseInt(parts[3]);
                    if (year.getValue() == yearOfRunning && month.getValue() == monthOfRunning) {
                        sum += Double.parseDouble(parts[0]);
                    }
                }
            }
            return sum;
        } catch (IOException e) {
            throw new IllegalStateException("Something went wrong", e);
        }
    }
}
