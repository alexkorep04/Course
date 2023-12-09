package edu.hw10.task1.entities;

import edu.hw10.task1.Max;
import edu.hw10.task1.Min;
import edu.hw10.task1.NotNull;
import java.util.Objects;

public class MyClass {
    private int firstField;
    private boolean secondField;
    private Long thirdField;
    private byte forthField;
    private float fifthField;

    public MyClass(
        @Max(10) @Min(0) @NotNull int firstField,
        @NotNull boolean secondField,
        @Min(5) @Max(100) Long thirdField,
        @Min(50) byte forthField,
        @Min(88.4) @Max(100) float fifthField
    ) {
        this.firstField = firstField;
        this.secondField = secondField;
        this.thirdField = thirdField;
        this.forthField = forthField;
        this.fifthField = fifthField;
    }

    public MyClass(int firstField, boolean secondField) {
        this.firstField = firstField;
        this.secondField = secondField;
    }

    public static MyClass create(@Max(11) @Min(0) int firstField, boolean secondField) {
        return new MyClass(firstField, secondField);
    }

    public int getFirstField() {
        return firstField;
    }

    public boolean getSecondField() {
        return secondField;
    }

    public Long getThirdField() {
        return thirdField;
    }

    public byte getForthField() {
        return forthField;
    }

    public float getFifthField() {
        return fifthField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MyClass myClass = (MyClass) o;
        return firstField == myClass.firstField && secondField == myClass.secondField
            && forthField == myClass.forthField && Float.compare(fifthField, myClass.fifthField) == 0
            && Objects.equals(thirdField, myClass.thirdField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstField, secondField, thirdField, forthField, fifthField);
    }
}
