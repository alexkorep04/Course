package edu.project2.solvers;

import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.LinkedList;
import java.util.List;

public interface Solver {
    List<Coordinate> findPath(Maze maze, Coordinate start, Coordinate end);

    default List<Coordinate> constructPath(int[][] parentX, int[][] parentY, Coordinate start, Coordinate end) {
        LinkedList<Coordinate> path = new LinkedList<>();
        int x = end.row();
        int y = end.col();
        while (x != start.row() || y != start.col()) {
            path.addFirst(new Coordinate(x, y));
            int tmpX = parentX[x][y];
            int tmpY = parentY[x][y];
            x = tmpX;
            y = tmpY;
        }
        path.addFirst(start);
        return path;
    }
}
