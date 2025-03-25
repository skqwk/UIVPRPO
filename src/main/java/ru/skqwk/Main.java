package ru.skqwk;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ClassLoader mainClassLoader = Main.class.getClassLoader();

        FileWordSet positiveSet = FileWordSet.of(mainClassLoader.getResource("positive_words.txt"));
        FileWordSet negativeSet = FileWordSet.of(mainClassLoader.getResource("negative_words.txt"));

        WordExtractor extractor = new WordExtractor();

        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(positiveSet, negativeSet);

        String positiveTextFile = "texts/positive_text.txt";
        List<String> positiveText = extractor.extract(mainClassLoader.getResource(positiveTextFile));
        System.out.printf("file: %s, result, %s\n", positiveTextFile, moodAnalyzer.analyze(positiveText));

        String neutralTextFile = "texts/neutral_text.txt";
        List<String> neutralText = extractor.extract(mainClassLoader.getResource(neutralTextFile));
        System.out.printf("file: %s, result, %s\n", neutralTextFile, moodAnalyzer.analyze(neutralText));

        String negativeTextFile = "texts/negative_text.txt";
        List<String> negativeText = extractor.extract(mainClassLoader.getResource(negativeTextFile));
        System.out.printf("file: %s, result, %s\n", negativeTextFile, moodAnalyzer.analyze(negativeText));
    }
}