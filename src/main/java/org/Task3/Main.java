package org.Task3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        List<Map.Entry<String, Integer>> wordCountList = getList();
        wordCountList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (Map.Entry<String, Integer> entry : wordCountList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static List<Map.Entry<String, Integer>> getList() throws FileNotFoundException {

        String text = ReadFile("Files/Task3/words.txt");

        String[] words = text.split("\\s+");

        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }
        return new ArrayList<>(wordCountMap.entrySet());
    }


    public static String ReadFile(String path) throws FileNotFoundException {
        File file = new File(path);
        FileInputStream fIs = new FileInputStream(file);
        Scanner scanner = new Scanner(fIs);
        StringBuilder text = new StringBuilder();
        while (scanner.hasNext()) {
            text.append(" ").append(scanner.nextLine());
        }
        return String.valueOf(text).trim();
    }

}