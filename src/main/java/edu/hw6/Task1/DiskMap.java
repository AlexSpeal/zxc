package edu.hw6.Task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {
    private final String directoryPath;

    DiskMap(String directoryPath) throws IOException {
        Path directory = Paths.get(directoryPath);

        if (Files.exists(directory) && !Files.isDirectory(directory)) {
            throw new IllegalArgumentException("Передается существующий файл");
        }
        if (!Files.exists(directory)) {
            Files.createDirectory(directory);
        }
        this.directoryPath = directoryPath;
    }

    private Path getPath() {
        return Paths.get(directoryPath);
    }

    private Path getPath(String path) {
        return Paths.get(directoryPath, path);
    }

    private void createFile(String filename) throws IOException {
        Path filePath = getPath(filename);
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }

    }

    @Override
    public int size() {
        try (var stream = Files.list(getPath())) {
            return (int) stream.filter(Files::isRegularFile).count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        if (!(key instanceof String)) {
            throw new IllegalArgumentException("Ключ обязан быть строкой");
        }

        return Files.exists(getPath((String) key));
    }

    @Override
    public boolean containsValue(Object value) {
        if (!(value instanceof String)) {
            throw new IllegalArgumentException("Значение должно быть строкой");
        }

        try (var stream = Files.list(getPath())) {
            return stream
                .filter(Files::isRegularFile)
                .anyMatch(path -> {
                    try {
                        return Objects.equals(Files.readString(path), value);
                    } catch (IOException e) {
                        return false;
                    }
                });
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public String get(Object key) {
        try {
            return Files.readString(getPath((String) key));
        } catch (IOException e) {
            return null;
        }
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        try {
            createFile(key);
            Files.writeString(getPath(key), value);
            return value;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String remove(Object key) {
        String oldValue = get(key);

        try {
            Files.deleteIfExists(getPath((String) key));
        } catch (IOException ignored) {
        }

        return oldValue;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        for (var entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        try (var stream = Files.list(getPath())) {
            stream.forEach(path -> {
                try {
                    Files.deleteIfExists(path);
                } catch (IOException ignored) {
                }
            });
        } catch (IOException ignored) {
        }
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        Set<String> keys = new HashSet<>();

        try (var stream = Files.list(getPath())) {

            stream.filter(Files::isRegularFile).forEach(path -> {
                keys.add(path.getFileName().toString());
            });
        } catch (IOException ignored) {
        }

        return keys;
    }

    @NotNull
    @Override
    public Collection<String> values() {
        Collection<String> values = new ArrayList<>();

        try (var stream = Files.list(getPath())) {
            stream.filter(Files::isRegularFile).forEach(path -> {
                try {
                    values.add(Files.readString(path));
                } catch (IOException ignored) {
                }
            });
        } catch (IOException ignored) {
        }

        return values;
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        Map<String, String> entries = new HashMap<>();

        try (var stream = Files.list(getPath())) {
            stream.forEach(path -> {
                if (Files.isRegularFile(path)) {
                    try {
                        entries.put(path.getFileName().toString(), Files.readString(path));
                    } catch (IOException ignored) {
                    }
                }
            });
        } catch (IOException ignored) {
        }

        return entries.entrySet();
    }
}
