package lgh;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

class AnagramFinderTest {

    private String filePath;

    @BeforeEach
    public void setUp() {
        URL resource = Main.class.getClassLoader().getResource("sample.txt");
        if (resource == null) {
            throw new IllegalArgumentException("File sample.txt not found in resources");
        }
        filePath = resource.getPath();
    }

    @Test
    public void find_whenInvoked_hasExpectedSize() throws IOException {
        var result = AnagramFinder.find(filePath);
        assertThat(result).hasSize(4);
    }

    @Test
    public void find_whenInvoked_containsExpectedKeys() throws IOException {
        var result = AnagramFinder.find(filePath);

        assertThat(result.keySet())
                .containsExactlyInAnyOrder("act", "eert", "acer", "bee");
    }


    @Test
    public void find_whenInvoked_containsExpectedGroups() throws IOException {
        var result = AnagramFinder.find(filePath);

        assertThat(result.get("act"))
                .containsExactlyInAnyOrder("cat", "act");

        assertThat(result.get("eert"))
                .containsExactlyInAnyOrder("tree");

        assertThat(result.get("acer"))
                .containsExactlyInAnyOrder("race", "care", "acre");

        assertThat(result.get("bee"))
                .containsExactlyInAnyOrder("bee");
    }

    @Test
    public void find_whenFindNotFound_throwException() throws IOException {
        String wrongPath = "wrong/path.txt";
        Assertions.assertThrows(IOException.class, () -> AnagramFinder.find(wrongPath));
    }

}