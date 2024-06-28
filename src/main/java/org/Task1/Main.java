package org.Task1;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static Pattern pattern1;
    private static Pattern pattern2;

    public static void main(String[] args) {
        pattern1 = Pattern.compile("\\(\\d{3}\\) \\d{3}-\\d{4}");
        pattern2 = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");


        readLinesAndValidate("Files/Task1/file.txt");


    }

    public static void readLinesAndValidate(String path) {
        try (Scanner fileScanner = new Scanner(new FileInputStream(path))) {

            while (fileScanner.hasNext()) {
                validate(fileScanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void validate(String num) {
        if (pattern1.matcher(num).matches() || pattern2.matcher(num).matches()) {
            System.out.println(num);
        }
    }
}