package edu.project1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConsoleHangmanClassTest extends ConsoleHangman {

    @Test
    @DisplayName("Correct input letter test - single letter")
    public void testCorrectInput()
    {
        String pattern = "a";
        ConsoleHangman consoleHangman = new ConsoleHangman();

        boolean response = consoleHangman.isCorrectInput(pattern);

        assertThat(response).isTrue();
    }
    @Test
    @DisplayName("Uncorrect input letter test - not letter")
    public void testUncorrectInputSingleSymbol()
    {
        String pattern = "!";
        ConsoleHangman consoleHangman = new ConsoleHangman();

        boolean response = consoleHangman.isCorrectInput(pattern);

        assertThat(response).isFalse();
    }

    @Test
    @DisplayName("Uncorrect input letter test - not one letter")
    public void testUncorrectInputNotOneSymbol()
    {
        String pattern = "abc";
        ConsoleHangman consoleHangman = new ConsoleHangman();

        boolean response = consoleHangman.isCorrectInput(pattern);

        assertThat(response).isFalse();
    }

}
