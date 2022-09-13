package com.course.a.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author freed
 * @Description:
 * @Date 2022-08-07
 */
public class TestFileReader {
    public static ArrayList<String> readFile(String fileName) {
        ArrayList<String> words = new ArrayList<>();
        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmedLine = line.trim();
                if (trimmedLine.isEmpty()) {
                    continue;
                }
                String[] lineWords = trimmedLine.split(" ");
                for (String word : lineWords) {
                    words.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
}
