package edu.hw4;

import edu.hw4.base.Animal;
import edu.hw4.base.Sex;
import edu.hw4.base.Type;
import edu.hw4.task.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    Task task;
    @BeforeEach
    public void createObjects() {
        task = new Task();
    }
    @Test
    @DisplayName("Test usual example of sorting by height")
    public void testSimpleSortingByHeight() {
        List<Animal> animals = List.of(new Animal("Rich", Type.CAT, Sex.M, 12, 40, 6,false)
            , new Animal("Tuzik", Type.DOG, Sex.M, 7, 60, 20,true)
            , new Animal("Vanessa", Type.BIRD, Sex.F, 1, 20, 1,true)
            , new Animal("Businka", Type.FISH, Sex.F, 2, 10, 1,true));

        List <Animal> expected = List.of( new Animal("Businka", Type.FISH, Sex.F, 2, 10, 1,true)
            ,new Animal("Vanessa", Type.BIRD, Sex.F, 1, 20, 1,true)
            , new Animal("Rich", Type.CAT, Sex.M, 12, 40, 6,false)
            , new Animal("Tuzik", Type.DOG, Sex.M, 7, 60, 20,true));

        List <Animal> response = task.sortAnimalsByHeight(animals);

        assertThat(response.size()).isEqualTo(expected.size());

        assertThat(response).isEqualTo(expected);
    }
    @Test
    @DisplayName("Test sorting by height on empty list")
    public void testSortingByHeightOnEmptyList() {
        List<Animal> animals = new ArrayList<>();

        List <Animal> expected = new ArrayList<>();

        List <Animal> response = task.sortAnimalsByHeight(animals);

        assertThat(response.size()).isEqualTo(expected.size());

        assertThat(response).isEqualTo(expected);
    }

}
