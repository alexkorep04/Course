package edu.hw10;

import edu.hw10.task1.entities.MyClass;
import edu.hw10.task1.entities.MyRecord;
import edu.hw10.task1.RandomObjectGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class Task1Test {
    RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();

    @Test
    @DisplayName("Test of creation object of class by constructor")
    public void testConstructorClass() {
        MyClass object = randomObjectGenerator.nextObject(MyClass.class);

        assertThat(object.getFirstField()).isBetween(0, 10);
        assertThat(object.getSecondField()).isNotNull();
        assertThat(object.getThirdField()).isBetween(5L, 100L);
        assertThat(object.getForthField()).isGreaterThan((byte) 49);
        assertThat(object.getFifthField()).isBetween((float) 88, (float) 100);
    }

    @Test
    @DisplayName("Test of creation object of class by fabric method")
    public void testMethodClass() {
        MyClass object = randomObjectGenerator.nextObject(MyClass.class, "create");

        assertThat(object.getFirstField()).isBetween(0, 11);
        assertThat(object.getSecondField()).isNotNull();
    }

    @Test
    @DisplayName("Test of creation object of record by constructor")
    public void testConstructorRecord() {
        MyRecord object = randomObjectGenerator.nextObject(MyRecord.class);

        assertThat(object.firstField()).isBetween('a', 'c');
        assertThat(object.secondField()).isLessThan((double) 4775);
        assertThat(object.thirdField()).isNotNull();
    }

    @Test
    @DisplayName("Test of creation object of record by fabric method")
    public void testMethodRecord() {
        MyRecord object = randomObjectGenerator.nextObject(MyRecord.class, "create");

        assertThat(object.firstField()).isBetween('a', 'c');
    }
}
