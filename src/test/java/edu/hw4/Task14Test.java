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

public class Task14Test {
    Task task;
    @BeforeEach
    public void createObjects() {
        task = new Task();
    }
    @Test
    @DisplayName("Test list where there is a dog with height more than k")
    public void testDogsWithHeightMoreThanK() {
        List<Animal> animals = List.of(new Animal("Rich", Type.DOG, Sex.M, 12, 100, 11,false)
            , new Animal("Tuzik", Type.DOG, Sex.M, 4, 110, 20,true)
            , new Animal("Kuzya", Type.DOG, Sex.M, 2, 50, 31,false)
            , new Animal("Vanesa", Type.BIRD, Sex.F, 4, 101, 1,true)
            , new Animal("Businka", Type.FISH, Sex.F, 0, 10, 2,true)
            , new Animal("Selena", Type.FISH, Sex.F, 1, 5, 6,true));

        boolean response = task.isDogHasHeightMoreK(animals, 105);

        assertThat(response).isTrue();
    }
    @Test
    @DisplayName("Test list where there is not a dog with height more than k")
    public void testDogsWithHeightMoreThanKNoInList() {
        List<Animal> animals = List.of(new Animal("Rich", Type.DOG, Sex.M, 12, 100, 11,false)
            , new Animal("Tuzik", Type.DOG, Sex.M, 4, 110, 20,true)
            , new Animal("Kuzya", Type.DOG, Sex.M, 2, 50, 31,false)
            , new Animal("Vanesa", Type.BIRD, Sex.F, 4, 101, 1,true)
            , new Animal("Businka", Type.FISH, Sex.F, 0, 10, 2,true)
            , new Animal("Selena", Type.FISH, Sex.F, 1, 5, 6,true));

        boolean response = task.isDogHasHeightMoreK(animals, 115);

        assertThat(response).isFalse();
    }
}
