package org.Task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        FileManipulator fileManipulator = new FileManipulator();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String[] words = fileManipulator.getString("Files/Task2/file.txt").split(" ");

        List<User> users = new ArrayList<>();

        for (int i = 2; i < words.length; i += 2) {
            String name = words[i];
            int age = Integer.parseInt(words[i + 1]);
            users.add(new User(name, age));
        }

        String jsonPath = "Files/Task2/file.json";

        fileManipulator.writeJson(jsonPath,gson,users);


    }
}
