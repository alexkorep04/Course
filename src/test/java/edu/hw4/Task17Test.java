package edu.hw4;

import edu.hw4.base.Animal;
import edu.hw4.base.Sex;
import edu.hw4.base.Type;
import edu.hw4.task.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task17Test {
    Task task;
    @BeforeEach
    public void createObjects() {
        task = new Task();
    }
    @Test
    @DisplayName("Test that spiders bite more often than dogs")
    public void testSpidersBiteOftenThanDogs() {
        List<Animal> animals = List.of(new Animal("Rich", Type.CAT, Sex.M, 12, 10, 11,false)
            , new Animal("Tuzik Petrov Vasya", Type.DOG, Sex.M, 4, 110, 20,false)
            , new Animal("Kuzya Ivanov", Type.DOG, Sex.F, 3, 30, 31,true)
            , new Animal("Vanesa Ojuf Tyre", Type.SPIDER, Sex.F, 1, 101, 1,true)
            , new Animal("Selena", Type.SPIDER, Sex.F, 3, 5, 6,true)
            , new Animal("Businka", Type.SPIDER, Sex.F, 0, 10, 2,false));

        boolean response = task.areSpidersBiteMoreOftenThanDogs(animals);

        assertThat(response).isTrue();
    }
    @Test
    @DisplayName("Test that spiders bite not more often than dogs")
    public void testSpidersBiteNotOftenThanDogs() {
        List<Animal> animals = List.of(new Animal("Rich", Type.CAT, Sex.M, 12, 10, 11,false)
            , new Animal("Tuzik Petrov Vasya", Type.DOG, Sex.M, 4, 110, 20,false)
            , new Animal("Kuzya Ivanov", Type.DOG, Sex.F, 3, 30, 31,true)
            , new Animal("Vanesa Ojuf Tyre", Type.CAT, Sex.F, 1, 101, 1,true)
            , new Animal("Selena", Type.SPIDER, Sex.F, 3, 5, 6,true)
            , new Animal("Businka", Type.SPIDER, Sex.F, 0, 10, 2,false));

        boolean response = task.areSpidersBiteMoreOftenThanDogs(animals);

        assertThat(response).isFalse();
    }
}
