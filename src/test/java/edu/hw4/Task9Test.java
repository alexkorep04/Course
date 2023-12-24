package edu.hw4;

import edu.hw4.base.Animal;
import edu.hw4.base.Sex;
import edu.hw4.base.Type;
import edu.hw4.task.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task9Test {
    Task task;
    @BeforeEach
    public void createObjects() {
        task = new Task();
    }
    @Test
    @DisplayName("Test how amount of paws are counting")
    public void testTheAmountOfPaws() {
        List<Animal> animals = List.of(new Animal("Rich", Type.CAT, Sex.M, 12, 40, 6,false)
            , new Animal("Tuzik", Type.DOG, Sex.M, 7, 60, 20,true)
            , new Animal("Kuzya", Type.BIRD, Sex.M, 3, 30, 5,false)
            , new Animal("Vanesa", Type.BIRD, Sex.F, 4, 20, 1,true)
            , new Animal("Businka", Type.FISH, Sex.F, 2, 10, 2,true)
            , new Animal("Selena", Type.FISH, Sex.F, 1, 5, 1,true));

        int expected = 12;

        int response = task.countAmountOfPaws(animals);

        assertThat(response).isEqualTo(expected);
    }
    @Test
    @DisplayName("Test how amount of paws are counting when only fishes")
    public void testTheAmountOfPawsWhenOnlyFishes() {
        List<Animal> animals = List.of(new Animal("Businka", Type.FISH, Sex.F, 2, 10, 2,true)
            , new Animal("Selena", Type.FISH, Sex.F, 1, 5, 1,true));

        int expected = 0;

        int response = task.countAmountOfPaws(animals);

        assertThat(response).isEqualTo(expected);
    }
}
