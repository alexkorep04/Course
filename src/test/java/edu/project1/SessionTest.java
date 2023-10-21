package edu.project1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SessionTest {
    Dictionary dictionary;
    @BeforeEach
    public void createObject()
    {
        List<String> list = new ArrayList<>();
        list.add("bmw");
        dictionary = new Dictionary(list);
    }
    @Test
    @DisplayName("Hit guess situation")
    public void testHitGuessSituation()
    {
        Session session = new Session(dictionary.randomWord(), 1);
        String pattern = "bmw";

        GuessResult response = session.guess('b');

        assertThat(response).isInstanceOf(GuessResult.SuccessfulGuess.class);
    }
    @Test
    @DisplayName("Failed guess situation")
    public void testFailedGuessSituation()
    {
        Session session = new Session(dictionary.randomWord(), 1);
        String pattern = "bmw";

        GuessResult response = session.guess('a');

        assertThat(response).isInstanceOf(GuessResult.FailedGuess.class);
    }
    @Test
    @DisplayName("Win game situation")
    public void testWinSituation()
    {
        Session session = new Session(dictionary.randomWord(), 1);
        String pattern = "bmw";
        session.guess('b');
        session.guess('m');

        GuessResult response = session.guess('w');

        assertThat(response).isInstanceOf(GuessResult.Win.class);
    }

    @Test
    @DisplayName("Lose game situation")
    public void testLoseSituation()
    {
        Session session = new Session(dictionary.randomWord(), 1);
        String pattern = "bmw";
        session.guess('a');

        GuessResult response = session.guess('c');

        assertThat(response).isInstanceOf(GuessResult.Defeat.class);
    }

}
