package edu.project2;

import edu.project2.generators.PrimMazeGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GeneratingTest {
    private int countOccurancesOfType(Type type, Cell[][] cells) {
        int cnt = 0;
        for(int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[0].length; j++) {
                if(cells[i][j].type() == type) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    @Test
    @DisplayName("Test correctness of creating maze")
    public void testGeneratingMaze() {
        PrimMazeGenerator generator = new PrimMazeGenerator(5, 6);

        Maze maze = generator.generateMaze();
        int cntStart = countOccurancesOfType(Type.START, maze.getGrid());
        int cntEnd = countOccurancesOfType(Type.END, maze.getGrid());

        assertThat(maze.getHeight()).isEqualTo(5);

        assertThat(maze.getWidth()).isEqualTo(6);

        assertThat(cntStart).isEqualTo(1);

        assertThat(cntEnd).isEqualTo(1);

    }
}
