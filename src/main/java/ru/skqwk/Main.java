package ru.skqwk;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassLoader mainClassLoader = Main.class.getClassLoader();

        FileWordSet positiveSet = FileWordSet.of(mainClassLoader.getResource("positive_words.txt"));
        FileWordSet negativeSet = FileWordSet.of(mainClassLoader.getResource("negative_words.txt"));

        WordExtractor extractor = new WordExtractor();

        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(positiveSet, negativeSet);

        List<String> positiveText = extractor.extract(mainClassLoader.getResource("texts/positive_text.txt"));
        System.out.println(moodAnalyzer.analyze(positiveText));

        List<String> neutralText = extractor.extract(mainClassLoader.getResource("texts/neutral_text.txt"));
        System.out.println(moodAnalyzer.analyze(neutralText));

        List<String> negativeText = extractor.extract(mainClassLoader.getResource("texts/negative_text.txt"));
        System.out.println(moodAnalyzer.analyze(negativeText));
    }
}