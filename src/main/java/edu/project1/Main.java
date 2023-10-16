package edu.project1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private Main() {
    }

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("Hi");
        words.add("Hello");
        words.add("Goodbye");
        Dictionary dictionary = new Dictionary(words);
        ConsoleHangman hangman = new ConsoleHangman(dictionary, 6);
        hangman.run();
    }
}
