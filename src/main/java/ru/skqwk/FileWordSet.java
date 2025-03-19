package ru.skqwk;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

public class FileWordSet {
    private final Set<String> words;

    public static FileWordSet of(URI uri) {
        return new FileWordSet(uri);
    }

    public static FileWordSet of(URL url) {
        try {
            return new FileWordSet(url.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }


    public FileWordSet(URI file) {
        try {
            this.words = Files.readAllLines(Path.of(file)).stream()
                    .map(String::trim)
                    .map(String::toLowerCase)
                    .filter(not(String::isBlank))
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean contains(String word) {
        return words.contains(word);
    }
}
