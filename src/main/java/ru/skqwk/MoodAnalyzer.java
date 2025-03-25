package ru.skqwk;

import com.github.demidko.aot.WordformMeaning;

import java.util.List;

public class MoodAnalyzer {

    private final FileWordSet positiveSet;
    private final FileWordSet negativeSet;

    public MoodAnalyzer(FileWordSet positiveSet,
                        FileWordSet negativeSet) {
        this.positiveSet = positiveSet;
        this.negativeSet = negativeSet;
    }

    public double analyze(List<String> words) {
        double sum = words.stream()
                .map(this::lemmatize)
                .mapToInt(this::sign)
                .sum();

        return sum / words.size();
    }

    private String lemmatize(String word) {
        try {
            return WordformMeaning.lookupForMeanings(word).get(0).getLemma().toString();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.printf("Ошибка при лемматизации слова - %s%n", word);
            throw e;
        }
    }

    /**
     * Определяем значение слова - положительное (1), отрицательное (-1) или нейтральное (0)
     */
    private int sign(String word) {
        if (negativeSet.contains(word)) {
            return -1;
        } else if (positiveSet.contains(word)) {
            return 1;
        } else {
            return 0;
        }
    }
}
