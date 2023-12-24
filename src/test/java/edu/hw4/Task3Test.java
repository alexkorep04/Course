package edu.hw4;

import edu.hw4.base.Animal;
import edu.hw4.base.Sex;
import edu.hw4.base.Type;
import edu.hw4.task.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    Task task;
    @BeforeEach
    public void createObjects() {
        task = new Task();
    }
    @Test
    @DisplayName("Test counting animals by type")
    public void testCountingAnimalsByType() {
        List<Animal> animals = List.of(new Animal("Rich", Type.CAT, Sex.M, 12, 40, 6,false)
            , new Animal("Tuzik", Type.DOG, Sex.M, 7, 60, 20,true)
            , new Animal("Vanessa", Type.BIRD, Sex.F, 1, 20, 1,true)
            , new Animal("Businka", Type.FISH, Sex.F, 2, 10, 1,true)
            , new Animal("Selena", Type.FISH, Sex.F, 1, 5, 1,true));

        Map<Type, Integer> expected = Map.of(Type.CAT, 1, Type.DOG, 1, Type.BIRD, 1, Type.FISH, 2);

        Map<Type, Integer> response = task.countAnimalsByType(animals);

        assertThat(response.keySet()).isEqualTo(expected.keySet());

        assertThat(response).isEqualTo(expected);
    }
}
