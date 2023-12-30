package edu.hw6.Task2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static edu.hw6.Task1.DiskMapTest.deleteDirectory;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CloneFileTest {
    private final static String DIRECTORY_PATH = "Task2test_clone_file";

    @BeforeEach
    void createCloneFIle() throws Exception {
        deleteDirectory(new File(DIRECTORY_PATH));
        Files.createDirectory(Path.of(DIRECTORY_PATH));
    }

    @AfterEach
    void deleteAllFiles() throws Exception {
        deleteDirectory(new File(DIRECTORY_PATH));
    }

    @Test
    @DisplayName("Первое успешное клонирование")
    void firstClone() throws IOException {
        Path path = Path.of(DIRECTORY_PATH, "test");
        Files.createFile(path);
        Files.writeString(path, "test");

        CloneFile.cloneFile(path);

        Path newPath = Path.of(DIRECTORY_PATH, "test - копия");
        assertThat(Files.exists(newPath)).isTrue();
        assertThat(Files.readString(newPath)).isEqualTo("test");
    }

    @Test
    @DisplayName("файла не существует")
    void notFile() {
        Path path = Path.of("aboba", "test");
        assertThrows(RuntimeException.class, () -> CloneFile.cloneFile(path));
    }

    @Test
    @DisplayName("Более одного успешного клонирования")
    void nClone() throws IOException {
        Path path = Path.of(DIRECTORY_PATH, "test");
        Files.createFile(path);
        CloneFile.cloneFile(path);
        CloneFile.cloneFile(path);

        assertThat(Files.exists(Path.of(DIRECTORY_PATH, "test - копия (2)"))).isTrue();
    }

    @Test
    @DisplayName("Работа с расширениями")
    void cloneWithExtension() throws IOException {
        Path path = Path.of(DIRECTORY_PATH, "test.txt");
        Files.createFile(path);
        CloneFile.cloneFile(path);

        assertThat(Files.exists(Path.of(DIRECTORY_PATH, "test - копия.txt"))).isTrue();
    }
}
