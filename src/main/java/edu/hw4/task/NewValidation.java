package edu.hw4.task;

import edu.hw4.base.Animal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class NewValidation {
    private NewValidation() {
    }

    @SuppressWarnings("MultipleStringLiterals")
    public static String getValidationErrors(Animal animal) {
        Set<NewValidationError> errors = new HashSet<>();
        if (animal.age() < 0) {
            errors.add(new NewValidationError("age", "Age can't be negative!"));
        }
        if (animal.age() == 0) {
            errors.add(new NewValidationError("age", "Age can't be 0!"));
        }
        if (animal.height() == 0) {
            errors.add(new NewValidationError("height", "Height can't be negative!"));
        }
        if (animal.height() < 0) {
            errors.add(new NewValidationError("height", "Height can't be 0!"));
        }
        if (animal.weight() == 0) {
            errors.add(new NewValidationError("weight", "Weight can't be 0!"));
        }
        if (animal.weight() < 0) {
            errors.add(new NewValidationError("weight", "Weight can't be negative!"));
        }
        if (animal.name().length() < 2) {
            errors.add(new NewValidationError("name", "Name can't be  so short!"));
        }
        return errors.stream()
            .map(error -> error.getFieldName() + ": " + error.getMessage())
            .collect(Collectors.joining(", "));
    }
}
