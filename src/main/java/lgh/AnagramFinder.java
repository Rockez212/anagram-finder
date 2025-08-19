package lgh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AnagramFinder {

    public static Map<String, Set<String>> find(String filePath) throws IOException {
        Map<String, Set<String>> anagramGroups = new HashMap<>();

        try (
                BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String word;
            while ((word = br.readLine()) != null) {
                word = word.trim();
                String key = generateKey(word);
                anagramGroups.putIfAbsent(key, new HashSet<>());
                anagramGroups.get(key).add(word);
            }
        } catch (
                IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            throw e;
        }

        return anagramGroups;
    }

    private static String generateKey(String word) {
        char[] letters = word.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }
}
