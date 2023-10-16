package edu.project1;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public class Session {

    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;
    public Session(String answer, int maxAttempts) {
        this.answer = answer;
        this.maxAttempts = maxAttempts;
        this.userAnswer = new char[answer.length()];
        for (int i = 0; i < answer.length(); i++) {
            userAnswer[i] = '*';
        }
        this.attempts = 0;
    }

    @NotNull
    public GuessResult guessResult() {
        return new GuessResult.SuccessfulGuess(userAnswer, attempts, maxAttempts, "");
    }

    public String getAnswer() {
        return answer;
    }

    @NotNull GuessResult guess(char guess) {
        if (attempts >= maxAttempts) {
            return new GuessResult.Defeat(userAnswer, attempts, maxAttempts, "You lost!\n");
        }
        boolean fl = false;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess) {
                fl = true;
                userAnswer[i] = guess;
            }
        }
        if (fl && String.valueOf(userAnswer).equals(answer)) {
            return new GuessResult.Win(userAnswer, attempts, maxAttempts, "You won!\n");
        }
        if (fl) {
            return new GuessResult.SuccessfulGuess(
                userAnswer,
                attempts,
                maxAttempts,
                "Hit!\nThe word is "
                    + Arrays.toString(userAnswer).replace("[", "").replace("]", "").replace(",", "").replace(" ", "")
            );
        }
        attempts++;
        return new GuessResult.FailedGuess(
            userAnswer,
            attempts,
            maxAttempts,
            "Missed, mistake " + attempts + " from " + maxAttempts + "\n" + "The word: "
                + Arrays.toString(userAnswer).replace("[", "").replace("]", "").replace(",", "").replace(" ", "")
        );
    }

    @NotNull GuessResult giveUp() {
        return new GuessResult.Defeat(
            userAnswer,
            attempts,
            maxAttempts,
            "You gave up. The word was:  " + answer + "\n"
        );
    }
}
