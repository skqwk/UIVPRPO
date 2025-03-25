package ru.skqwk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileWordSetTest {

    @ParameterizedTest
    @MethodSource("containsDataProvider")
    void contains(String word, boolean expected) {
        // given
        FileWordSet wordSet = FileWordSet.of(FileWordSetTest.class.getClassLoader().getResource("words.txt"));

        // when | then
        assertEquals(expected, wordSet.contains(word));
    }

    private static Stream<Arguments> containsDataProvider() {
        return Stream.of(
                Arguments.of("дождь", true),
                Arguments.of("солнце", true),
                Arguments.of("ветер", true),
                Arguments.of("луна", false)
        );
    }
}