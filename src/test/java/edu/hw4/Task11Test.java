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

public class Task11Test {
    Task task;
    @BeforeEach
    public void createObjects() {
        task = new Task();
    }
    @Test
    @DisplayName("Test list of animals that can't bite and height is more than 100")
    public void testAnimalsThatCanBiteAndHeightIsMoreThanOntHundred() {
        List<Animal> animals = List.of(new Animal("Rich", Type.CAT, Sex.M, 12, 120, 6,false)
            , new Animal("Tuzik", Type.DOG, Sex.M, 4, 110, 20,true)
            , new Animal("Kuzya", Type.BIRD, Sex.M, 2, 30, 5,false)
            , new Animal("Vanesa", Type.BIRD, Sex.F, 4, 101, 1,true)
            , new Animal("Businka", Type.FISH, Sex.F, 0, 10, 2,true)
            , new Animal("Selena", Type.FISH, Sex.F, 1, 5, 1,true));

        List<Animal> expected = List.of(new Animal("Tuzik", Type.DOG, Sex.M, 4, 110, 20,true)
            , new Animal("Vanesa", Type.BIRD, Sex.F, 4, 101, 1,true));

        List<Animal> response = task.getAnimalsAbleToBite(animals);

        assertThat(response.size()).isEqualTo(expected.size());

        assertThat(response).isEqualTo(expected);
    }
}
