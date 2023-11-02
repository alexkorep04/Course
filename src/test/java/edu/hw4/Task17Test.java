package edu.hw4;

import edu.hw4.base.Animal;
import edu.hw4.base.Sex;
import edu.hw4.base.Type;
import edu.hw4.task.Task;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task17Test {
    Task task;
    List<Animal> animals1;
    List<Animal> animals2;
    @BeforeEach
    public void createObjects() {
        task = new Task();
    }
    @BeforeEach
    public void createAnimals() {
        animals1 = List.of(new Animal("Rich", Type.CAT, Sex.M, 12, 10, 11,false)
            , new Animal("Tuzik Petrov Vasya", Type.DOG, Sex.M, 4, 110, 20,false)
            , new Animal("Kuzya Ivanov", Type.DOG, Sex.F, 3, 30, 31,true)
            , new Animal("Vanesa Ojuf Tyre", Type.SPIDER, Sex.F, 1, 101, 1,true)
            , new Animal("Selena", Type.SPIDER, Sex.F, 3, 5, 6,true)
            , new Animal("Businka", Type.SPIDER, Sex.F, 0, 10, 2,false));
        animals2 = List.of(new Animal("Rich", Type.CAT, Sex.M, 12, 10, 11,false)
            , new Animal("Tuzik Petrov Vasya", Type.DOG, Sex.M, 4, 110, 20,false)
            , new Animal("Kuzya Ivanov", Type.DOG, Sex.F, 3, 30, 31,true)
            , new Animal("Vanesa Ojuf Tyre", Type.CAT, Sex.F, 1, 101, 1,true)
            , new Animal("Selena", Type.SPIDER, Sex.F, 3, 5, 6,true)
            , new Animal("Businka", Type.SPIDER, Sex.F, 0, 10, 2,false));
    }
    @Test
    @DisplayName("Test that spiders bite more often than dogs")
    public void testSpidersBiteOftenThanDogs() {
        boolean response = task.areSpidersBiteMoreOftenThanDogs(animals1);

        assertThat(response).isTrue();
    }
    @Test
    @DisplayName("Test that spiders bite not more often than dogs")
    public void testSpidersBiteNotOftenThanDogs() {
        boolean response = task.areSpidersBiteMoreOftenThanDogs(animals2);

        assertThat(response).isFalse();
    }
}
