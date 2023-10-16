package edu.project1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.ArrayList;
import java.util.List;

public class DictionaryClassTest {
    Dictionary dictionary;
    @BeforeEach
    public void createObject()
    {
        List<String> words = new ArrayList<>();
        words.add("audi");
        words.add("bmw");
        words.add("skoda");
        words.add("lada");
        dictionary = new Dictionary(words);
    }
    @Test
    @DisplayName("Check that random word is from list")
    public void checkThatRandomWordIsAtList()
    {
        boolean expected = true;
        boolean response = dictionary.getWords().contains(dictionary.randomWord());
        assertThat(expected).isEqualTo(response);
    }
    @Test
    @DisplayName("Check that new word was added to list")
    public void checkAddingOfNewWord()
    {
        String newWord = "nissan";
        dictionary.addWord(newWord);
        boolean expected = true;
        boolean response = dictionary.getWords().contains(newWord);
        assertThat(expected).isEqualTo(response);
    }
}
