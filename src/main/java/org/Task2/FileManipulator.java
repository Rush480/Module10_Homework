package org.Task2;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManipulator {

    public String getString(String path) {
        File file = new File(path);
        StringBuilder text = null;

        try (FileInputStream fs = new FileInputStream(file);
             Scanner scanner = new Scanner(fs)) {
            text = new StringBuilder();

            while (scanner.hasNext()) {
                text.append(scanner.nextLine());
                text.append(" ");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return String.valueOf(text);
    }

    public <T> void writeJson(String path, Gson gson,T users) throws IOException {
        try (FileWriter writer = new FileWriter(path)) {
        gson.toJson(users, writer);
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
