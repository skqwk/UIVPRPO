package ru.skqwk;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordExtractor {

    List<String> extract(URL path) {
        try {
            return Files.readAllLines(Path.of(path.toURI()))
                    .stream()
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .map(word -> word.replaceAll("[^a-zA-Zа-яА-Я0-9\\s]", ""))
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
