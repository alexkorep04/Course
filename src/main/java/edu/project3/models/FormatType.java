package edu.project3.models;

import java.util.Arrays;

public enum FormatType {
    ADOC("adoc"),
    MARKDOWN("markdown");

    FormatType(String description) {
        this.description = description;
    }

    public String description;

    public static FormatType findByValue(String value) {
        return Arrays.stream(values())
            .filter(formatType -> formatType.description.equals(value))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Not correct value!"));
    }
}
