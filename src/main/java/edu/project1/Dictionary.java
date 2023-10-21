package edu.project1;

import java.util.List;
import org.jetbrains.annotations.NotNull;


public class Dictionary {
    List<String> words;

    public Dictionary(List<String> words) {
        this.words = words;
    }

    public void addWord(String word) {
        words.add(word);
    }

    @NotNull

    public String randomWord() {
        int randomIndex = (int) (Math.random() * words.size());
        return words.get(randomIndex);
    }

    public List<String> getWords() {
        return words;
    }
}
