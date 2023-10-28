package edu.project2;

import edu.project2.solvers.BFSLabyrinthSolver;
import edu.project2.solvers.DFSLabyrinthSolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SolversTest {
    Maze maze;
    Cell[][] cells;
    BFSLabyrinthSolver bfsLabyrinthSolver;
    DFSLabyrinthSolver dfsLabyrinthSolver;
    @BeforeEach
    public void createMaze() {
        cells = new Cell[5][5];
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                cells[i][j] = new Cell(new Coordinate(i, j), Type.PASSAGE);
            }
        }
        cells[0][0] = new Cell(new Coordinate(0, 0), Type.WALL);
        cells[0][1] = new Cell(new Coordinate(0, 1), Type.START);
        cells[0][2] = new Cell(new Coordinate(0, 2), Type.WALL);
        cells[0][3] = new Cell(new Coordinate(0, 3), Type.WALL);
        cells[0][4] = new Cell(new Coordinate(0, 4), Type.WALL);
        cells[1][2] = new Cell(new Coordinate(1, 2), Type.WALL);
        cells[2][2] = new Cell(new Coordinate(2, 2), Type.WALL);
        cells[2][0] = new Cell(new Coordinate(2, 0), Type.WALL);
        cells[3][4] = new Cell(new Coordinate(3, 4), Type.WALL);
        cells[4][1] = new Cell(new Coordinate(4, 1), Type.WALL);
        cells[4][3] = new Cell(new Coordinate(4, 3), Type.WALL);
        bfsLabyrinthSolver = new BFSLabyrinthSolver();
        dfsLabyrinthSolver = new DFSLabyrinthSolver();
        maze = new Maze(5, 5, cells);
    }
    @Test
    @DisplayName("Test how BFS solvers finds path from start to end point")
    public void testBFSSolver() {
        List<Coordinate> expected = new LinkedList<>(List.of(new Coordinate(0, 1), new Coordinate(1, 1),new Coordinate(2, 1),new Coordinate(3, 1),new Coordinate(3, 2),new Coordinate(3, 3),new Coordinate(2, 3),new Coordinate(2, 4)));

        List<Coordinate> response = bfsLabyrinthSolver.findPath(maze, new Coordinate(0, 1), new Coordinate(2, 4));

        assertThat(response.size()).isEqualTo(expected.size());

        assertThat(response).isEqualTo(expected);
    }
    @Test
    @DisplayName("Test how BFS solvers finds path from start to end point where end point is unreachable")
    public void testBFSSolverNotReachableEndPoint() {
        List<Coordinate> response = bfsLabyrinthSolver.findPath(maze, new Coordinate(0, 1), new Coordinate(4, 4));

        assertNull(response);
    }
    @Test
    @DisplayName("Test how DFS solvers finds path from start to end point")
    public void testDFSSolver() {
        List<Coordinate> expected = new LinkedList<>(List.of(new Coordinate(0, 1), new Coordinate(1, 1),new Coordinate(2, 1),new Coordinate(3, 1),new Coordinate(3, 2),new Coordinate(3, 3),new Coordinate(2, 3),new Coordinate(2, 4)));

        List<Coordinate> response = dfsLabyrinthSolver.findPath(maze, new Coordinate(0, 1), new Coordinate(2, 4));

        assertThat(response.size()).isEqualTo(expected.size());

        assertThat(response).isEqualTo(expected);
    }
    @Test
    @DisplayName("Test how DFS solvers finds path from start to end point where end point is unreachable")
    public void testDFSSolverNotReachableEndPoint() {
        List<Coordinate> response = dfsLabyrinthSolver.findPath(maze, new Coordinate(0, 1), new Coordinate(4, 4));

        assertNull(response);
    }
}
