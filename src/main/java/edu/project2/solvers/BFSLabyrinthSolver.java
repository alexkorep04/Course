package edu.project2.solvers;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import edu.project2.Type;
import java.util.LinkedList;
import java.util.Queue;

public class BFSLabyrinthSolver implements Solver {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static boolean isValid(int x, int y, Cell[][] maze) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && !(maze[x][y].type() == Type.WALL);
    }

    @Override
    public LinkedList<Coordinate> findPath(Maze maze1, Coordinate start, Coordinate end) {
        Cell[][] maze = maze1.getGrid();
        int m = maze1.getWidth();
        int n = maze1.getHeight();
        boolean[][] visited = new boolean[m][n];
        int[][] parentX = new int[m][n];
        int[][] parentY = new int[m][n];
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.row()][start.col()] = true;
        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            if (current.row() == end.row() && current.col() == end.col()) {
                return constructPath(parentX, parentY, start, end);
            }
            for (int[] dir : DIRECTIONS) {
                int newX = current.row() + dir[0];
                int newY = current.col() + dir[1];
                if (isValid(newX, newY, maze) && !visited[newX][newY]) {
                    queue.offer(new Coordinate(newX, newY));
                    visited[newX][newY] = true;
                    parentX[newX][newY] = current.row();
                    parentY[newX][newY] = current.col();
                }
            }
        }
        return null;
    }
}
