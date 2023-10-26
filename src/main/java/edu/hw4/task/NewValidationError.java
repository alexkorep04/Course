package edu.hw4.task;

import java.util.Objects;

public class NewValidationError {
    private String fieldName;
    private String message;

    public NewValidationError(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NewValidationError that = (NewValidationError) o;
        return Objects.equals(fieldName, that.fieldName) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldName, message);
    }
}
