package ru.skqwk;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordExtractorTest {

    @Test
    void extract() {
        // given
        WordExtractor extractor = new WordExtractor();

        // when
        List<String> actualResult = extractor
                .extract(WordExtractorTest.class.getClassLoader().getResource("text.txt"));

        // then
        assertTrue(actualResult.contains("взглядами"));
        assertTrue(actualResult.contains("летал"));
        assertTrue(actualResult.contains("настроение"));
        assertTrue(actualResult.contains("серые"));

        assertFalse(actualResult.contains("солнце"));
        assertFalse(actualResult.contains("радость"));
        assertFalse(actualResult.contains("городами"));
    }
}