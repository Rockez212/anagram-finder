package lgh;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = getFilePath();
        var result = AnagramFinder.find(filePath);
        print(result);
    }

    private static String getFilePath() {
        URL resource = Main.class.getClassLoader().getResource("sample.txt");
        if (resource == null) {
            throw new IllegalArgumentException("File sample.txt not found in resources");
        }
        return resource.getPath();
    }

    private static void print(Map<String, Set<String>> anagramGroups) {
        for (Set<String> group : anagramGroups.values()) {
            System.out.println(String.join(" ", group));
        }
    }

}