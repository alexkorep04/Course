package edu.project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleHangman {
    private final Dictionary dictionary;
    private final int maxAttempts;
    private final static Logger LOGGER = LogManager.getLogger();

    public ConsoleHangman(Dictionary dictionary, int maxAttempts) {
        this.dictionary = dictionary;
        this.maxAttempts = maxAttempts;
    }

    public ConsoleHangman() {
        List<String> list = new ArrayList<>();
        dictionary = new Dictionary(list);
        maxAttempts = 1;
    }

    protected boolean isCorrectInput(String input) {
        return input.length() == 1 && Character.isLetter(input.charAt(0));
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Session session = new Session(dictionary.randomWord().toLowerCase(), maxAttempts);
        if(session.getAnswer().length() < 3) {
            LOGGER.info("Sorry, the game is broken! Try to run it again!");
            return;
        }
        GuessResult guessResult = session.guessResult();
        LOGGER.info("Welcome to a Hangman game! To give up you should enter word surrender");
        while (true) {
            if (guessResult instanceof GuessResult.Defeat || guessResult instanceof GuessResult.Win) {
                break;
            }
            LOGGER.info("Guess a letter: ");
            String input = scanner.nextLine().toLowerCase();
            if(input.equals("surrender")) {
                guessResult = session.giveUp();
                printState(guessResult);
            }
            if (isCorrectInput(input)) {
                char guess = input.charAt(0);
                guessResult = session.guess(guess);
                printState(guessResult);
            } else {
                LOGGER.info("Invalid input. Please enter a single letter.");
            }
        }
    }

    private void printState(GuessResult guessResult) {
        LOGGER.info(guessResult.message());
    }
}
