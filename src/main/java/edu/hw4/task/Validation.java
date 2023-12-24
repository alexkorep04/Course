package edu.hw4.task;

import edu.hw4.base.Animal;
import java.util.HashSet;
import java.util.Set;

public class Validation {
    private Validation() {
    }

    public static Set<ValidationError> validateAnimal(Animal animal) {
        Set<ValidationError> errors = new HashSet<>();
        if (animal.age() < 0) {
            errors.add(new ValidationError("Age can't be negative!"));
        }
        if (animal.age() == 0) {
            errors.add(new ValidationError("Age can't be 0!"));
        }
        if (animal.height() == 0) {
            errors.add(new ValidationError("Height can't be 0!"));
        }
        if (animal.height() < 0) {
            errors.add(new ValidationError("Height can't be negative!"));
        }
        if (animal.weight() == 0) {
            errors.add(new ValidationError("Weight can't be 0!"));
        }
        if (animal.weight() < 0) {
            errors.add(new ValidationError("Weight can't be negative!"));
        }
        if (animal.name().length() < 2) {
            errors.add(new ValidationError("Name can't be so short!"));
        }
        return errors;
    }
}
