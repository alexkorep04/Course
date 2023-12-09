package edu.hw10.task1.entities;

import edu.hw10.task1.Max;
import edu.hw10.task1.Min;
import edu.hw10.task1.NotNull;

public record MyRecord(@Max('c') @Min('a') Character firstField, @Max(4774.32) Double secondField,
                       @NotNull String thirdField) {
    public MyRecord(Character firstField) {
        this(firstField, null, null);
    }

    public static MyRecord create(@Max('c') @Min('a') Character firstField) {
        return new MyRecord(firstField);
    }
}
