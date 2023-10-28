package edu.project2.solvers;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import edu.project2.Type;
import java.util.LinkedList;
import java.util.Stack;

public class DFSLabyrinthSolver implements Solver {
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
        Stack<Coordinate> stack = new Stack<>();
        stack.push(start);
        visited[start.row()][start.col()] = true;

        while (!stack.isEmpty()) {
            Coordinate current = stack.pop();
            if (current.row() == end.row() && current.col() == end.col()) {
                return constructPath(parentX, parentY, start, end);
            }

            for (int[] dir : DIRECTIONS) {
                int newX = current.row() + dir[0];
                int newY = current.col() + dir[1];
                if (isValid(newX, newY, maze) && !visited[newX][newY]) {
                    stack.push(new Coordinate(newX, newY));
                    visited[newX][newY] = true;
                    parentX[newX][newY] = current.row();
                    parentY[newX][newY] = current.col();
                }
            }
        }

        return null;
    }


    /*public static void main(String[] args) {
        PrimMazeGenerator mazeGenerator = new PrimMazeGenerator(20, 20);
        Maze cells = mazeGenerator.generateMaze();
        Coordinate start = null;
        Coordinate end = null;
        char whiteRectangle = '\u25A0';
        char greenRectangle = '■';
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (cells.getGrid()[i][j].type() == Type.PASSAGE) {
                    System.out.print(' ');
                } else if (cells.getGrid()[i][j].type() == Type.WALL) {
                    System.out.print(whiteRectangle);
                } else if (cells.getGrid()[i][j].type() == Type.START) {
                    System.out.print('S');
                    start = cells.getGrid()[i][j].coordinate();
                } else {
                    System.out.print('E');
                    end = cells.getGrid()[i][j].coordinate();
                }
            }
            System.out.println();
        }
        LinkedList<Coordinate> path = findPathDFS(cells, start, end);
        if (path != null) {
            System.out.println("Путь найден:");
            for (Coordinate point : path) {
                if (!((point.row() == start.row() && point.col() == start.col()) ||
                    (point.row() == end.row() && point.col() == end.col()))) {
                    cells.getGrid()[point.row()][point.col()] = new Cell(point, Type.PATH);
                }
            }
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if (cells.getGrid()[i][j].type() == Type.PASSAGE) {
                        System.out.print(' ');
                    } else if (cells.getGrid()[i][j].type() == Type.WALL) {
                        System.out.print(whiteRectangle);
                    } else if (cells.getGrid()[i][j].type() == Type.START) {
                        System.out.print('S');
                        start = cells.getGrid()[i][j].coordinate();
                    } else if (cells.getGrid()[i][j].type() == Type.END) {
                        System.out.print('E');
                        end = cells.getGrid()[i][j].coordinate();
                    } else {
                        System.out.print('+');
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("Путь не найден.");
        }
    }*/
}
