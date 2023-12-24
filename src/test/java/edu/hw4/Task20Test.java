package edu.hw4;

import edu.hw4.base.Animal;
import edu.hw4.base.Sex;
import edu.hw4.base.Type;
import edu.hw4.task.Task;
import edu.hw4.task.ValidationError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task20Test {
    Task task;
    @BeforeEach
    public void createObjects() {
        task = new Task();
    }
    @Test
    @DisplayName("Test how the new validation errors are contained in map")
    public void testSpidersBiteOftenThanDogs() {
        List<Animal> animals = List.of(new Animal("Rich", Type.CAT, Sex.M, 12, 10, 11,false)
            , new Animal("Tuzik Petrov Vasya", Type.DOG, Sex.M, -1, -2, 20,false)
            , new Animal("Kuzya Ivanov", Type.DOG, Sex.F, 3, 30, 31,true)
            , new Animal("Vanesa Ojuf Tyre", Type.SPIDER, Sex.F, 0, 101, 1,true)
            , new Animal("Selena", Type.FISH, Sex.F, 3, 5, 6,true)
            , new Animal("Businka", Type.FISH, Sex.F, 2, 3, 4,false));


        Map<String, String> expected = Map.of("Rich", "", "Tuzik Petrov Vasya", "age: Age can't be negative!, height: Height can't be 0!",
            "Kuzya Ivanov", "",  "Vanesa Ojuf Tyre", "age: Age can't be 0!", "Selena", "", "Businka", "");

        Map<String, String> response = task.getAnimalsWithErrorsWithFields(animals);

        assertThat(response.keySet()).isEqualTo(expected.keySet());

        assertThat(response).isEqualTo(expected);
    }
}
