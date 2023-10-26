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

public class Task5Test {
    Task task;
    @BeforeEach
    public void createObjects() {
        task = new Task();
    }
    @Test
    @DisplayName("Test the most popular sex when females are more than males")
    public void testTheMostPopularSex() {
        List<Animal> animals = List.of(new Animal("Rich", Type.CAT, Sex.M, 12, 40, 6,false)
            , new Animal("Tuzik", Type.DOG, Sex.M, 7, 60, 20,true)
            , new Animal("Vanesa", Type.BIRD, Sex.F, 1, 20, 1,true)
            , new Animal("Businka", Type.FISH, Sex.F, 2, 10, 1,true)
            , new Animal("Selena", Type.FISH, Sex.F, 1, 5, 1,true));

        Sex expected = Sex.F;

        Sex response = task.countAnimalsWithPopularSex(animals);

        assertThat(response).isEqualTo(expected);
    }

    @Test
    @DisplayName("Test the most popular sex when females amount are equal with males")
    public void testTheMostPopularSexWhenEqual() {
        List<Animal> animals = List.of(new Animal("Rich", Type.CAT, Sex.M, 12, 40, 6,false)
            , new Animal("Tuzik", Type.DOG, Sex.M, 7, 60, 20,true)
            , new Animal("Businka", Type.FISH, Sex.F, 2, 10, 1,true)
            , new Animal("Selena", Type.FISH, Sex.F, 1, 5, 1,true));

        Sex expected = Sex.F;

        Sex response = task.countAnimalsWithPopularSex(animals);

        assertThat(response).isEqualTo(expected);
    }
}
