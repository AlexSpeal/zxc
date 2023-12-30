package edu.hw6.Task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class ChainTest {
    private final static String DIRECTORY_PATH = "test_chain.txt";

    @Test
    void testChain() throws IOException {
        Path path = Path.of(DIRECTORY_PATH);
        Files.createFile(path);
        Chain.streamsChain(path);

        assertThat(Files.readString(path)).isEqualTo("Programming is learned by writing programs. ― Brian Kernighan");
        Files.delete(path);
    }
}
