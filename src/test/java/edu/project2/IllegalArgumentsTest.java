package edu.project2;

import edu.project2.generators.PrimMazeGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class IllegalArgumentsTest {
    @Test
    @DisplayName("Test when raw amount is to small")
    public void testIllegalArgumentsWithSmallData() {
        PrimMazeGenerator generator = new PrimMazeGenerator(3, 5);

        Assertions.assertThrows(IllegalArgumentException.class, generator::generateMaze);
    }
    @Test
    @DisplayName("Test when raw and col are uncorrect")
    public void testIllegalArgumentsWithBigData() {
        PrimMazeGenerator generator = new PrimMazeGenerator(10002, 10001);

        Assertions.assertThrows(IllegalArgumentException.class, generator::generateMaze);
    }
}
