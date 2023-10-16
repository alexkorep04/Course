package edu.project1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHangmanClassTest {
    ConsoleHangman consoleHangman;
    @BeforeEach
    public void createObject()
    {
        List<String> words = new ArrayList<>();
        words.add("hi");
        consoleHangman = new ConsoleHangman(new Dictionary(words), 4);
    }

}
