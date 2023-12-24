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

public class Task16Test {
    Task task;
    @BeforeEach
    public void createObjects() {
        task = new Task();
    }
    @Test
    @DisplayName("Test the summary weight of animals by typed that has age from k to l")
    public void testSummaryWeightOfAnimals() {
        List<Animal> animals = List.of(new Animal("Rich", Type.CAT, Sex.M, 12, 10, 11,false)
            , new Animal("Tuzik Petrov Vasya", Type.DOG, Sex.M, 4, 110, 20,true)
            , new Animal("Kuzya Ivanov", Type.DOG, Sex.F, 3, 30, 31,false)
            , new Animal("Vanesa Ojuf Tyre", Type.BIRD, Sex.F, 1, 101, 1,true)
            , new Animal("Selena", Type.FISH, Sex.F, 3, 5, 6,true)
            , new Animal("Businka", Type.FISH, Sex.F, 0, 10, 2,true));

        List<Animal> expected = List.of(new Animal("Vanesa Ojuf Tyre", Type.BIRD, Sex.F, 1, 101, 1,true)
            , new Animal("Rich", Type.CAT, Sex.M, 12, 10, 11,false)
            , new Animal("Kuzya Ivanov", Type.DOG, Sex.F, 3, 30, 31,false)
            , new Animal("Tuzik Petrov Vasya", Type.DOG, Sex.M, 4, 110, 20,true)
            , new Animal("Businka", Type.FISH, Sex.F, 0, 10, 2,true)
            , new Animal("Selena", Type.FISH, Sex.F, 3, 5, 6,true));


       List<Animal> response = task.sortByParameters(animals);

        assertThat(response).isEqualTo(expected);
    }
}
