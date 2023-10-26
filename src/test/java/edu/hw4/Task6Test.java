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

public class Task6Test {
    Task task;
    @BeforeEach
    public void createObjects() {
        task = new Task();
    }
    @Test
    @DisplayName("Test how the heaviest animal of every type")
    public void testTheHeaviestAnimalOfEveryType() {
        List<Animal> animals = List.of(new Animal("Rich", Type.CAT, Sex.M, 12, 40, 6,false)
            , new Animal("Tuzik", Type.DOG, Sex.M, 7, 60, 20,true)
            , new Animal("Kuzya", Type.BIRD, Sex.M, 1, 30, 2,false)
            , new Animal("Vanesa", Type.BIRD, Sex.F, 1, 20, 1,true)
            , new Animal("Businka", Type.FISH, Sex.F, 2, 10, 2,true)
            , new Animal("Selena", Type.FISH, Sex.F, 1, 5, 1,true));

        Map<Type, Animal> expected = Map.of(Type.CAT, new Animal("Rich", Type.CAT, Sex.M, 12, 40, 6,false)
            , Type.DOG, new Animal("Tuzik", Type.DOG, Sex.M, 7, 60, 20,true)
            , Type.BIRD, new Animal("Kuzya", Type.BIRD, Sex.M, 1, 30, 2,false)
            , Type.FISH, new Animal("Businka", Type.FISH, Sex.F, 2, 10, 2,true));

        Map<Type, Animal> response = task.getHeaviestAnimalOfEveryType(animals);

        assertThat(response.keySet()).isEqualTo(expected.keySet());

        assertThat(response).isEqualTo(expected);
    }
}
