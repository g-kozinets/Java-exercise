package com.company;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final String PATH_TO_INPUT = "newfile.txt";

    public static void main(String[] args) throws IOException {

        List<EmployeeLogEntry> log = new ArrayList<>();


        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(PATH_TO_INPUT)
                )
        )) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                log.add(new EmployeeLogEntry(line.split(" ")[0], true));
                log.add(new EmployeeLogEntry(line.split(" ")[1], false));

            }
        } catch (IIOException e) {
        }



        Collections.sort(log);

        for (EmployeeLogEntry empl : log) {
            System.out.println(empl);
        }


        int max = 0;
        int current = 0;
        for (EmployeeLogEntry logEntry : log) {
            current += logEntry.applyToSum();
            if (current > max) {
                max = current;
            }
        }
        System.out.println("Max number of employees " + max);
    }
}

