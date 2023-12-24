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

public class Task18Test {
    Task task;
    @BeforeEach
    public void createObjects() {
        task = new Task();
    }
    @Test
    @DisplayName("Test how the heaviest fish is getting from 2 list")
    public void testSpidersBiteOftenThanDogs() {
        List<Animal> animals1 = List.of(new Animal("Rich", Type.CAT, Sex.M, 12, 10, 11,false)
            , new Animal("Tuzik Petrov Vasya", Type.DOG, Sex.M, 4, 110, 20,false)
            , new Animal("Kuzya Ivanov", Type.DOG, Sex.F, 3, 30, 31,true)
            , new Animal("Vanesa Ojuf Tyre", Type.SPIDER, Sex.F, 1, 101, 1,true)
            , new Animal("Selena", Type.FISH, Sex.F, 3, 5, 6,true)
            , new Animal("Businka", Type.FISH, Sex.F, 0, 10, 4,false));
        List<Animal> animals2 = List.of(new Animal("Rich2", Type.CAT, Sex.M, 12, 10, 11,false)
            , new Animal("Tuzik Petrov Vasya2", Type.DOG, Sex.M, 4, 110, 20,false)
            , new Animal("Kuzya Ivanov2", Type.DOG, Sex.F, 3, 30, 31,true)
            , new Animal("Vanesa Ojuf Tyre2", Type.SPIDER, Sex.F, 1, 101, 1,true)
            , new Animal("Selena2", Type.FISH, Sex.F, 3, 5, 10,true)
            , new Animal("Businka2", Type.CAT, Sex.F, 0, 10, 4,false));

        Animal expected = new Animal("Selena2", Type.FISH, Sex.F, 3, 5, 10,true);

        Animal response = task.getTheHeaviestFish(animals1, animals2);

        assertThat(response).isEqualTo(expected);
    }
}
