package edu.hw4.task;

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
}
