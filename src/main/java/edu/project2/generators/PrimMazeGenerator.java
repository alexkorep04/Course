package edu.project2.generators;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import edu.project2.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PrimMazeGenerator implements Generator {
    private final int[] dx = {-1, 1, 0, 0};
    private final int[]  dy = {0, 0, -1, 1};
    private final int row;
    private final int col;
    private final Random random;

    public PrimMazeGenerator(int row, int col) {
        this.row = row;
        this.col = col;
        random = new Random();
    }

    private Cell[][] fillGrid() {
       Cell[][] cells = new Cell[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                cells[i][j] = new Cell(coordinate, Type.WALL);
            }
        }
        return cells;
    }

    private Cell getStartPoint(Cell[][] cells) {
        int startRow = random.nextInt(row);
        int startCol = random.nextInt(col);
        Coordinate start = new Coordinate(startRow, startCol);
        cells[startRow][startCol] = new Cell(start, Type.START);
        return cells[startRow][startCol];
    }

    private void markEndPoint(Cell[][] cells, Cell startCell) {
        do {
            int exitRow = random.nextInt(row);
            int exitCol = random.nextInt(col);
            if (exitRow != startCell.coordinate().row()
                && exitCol != startCell.coordinate().col() && cells[exitRow][exitCol].type() == Type.PASSAGE) {
                Coordinate coordinate = new Coordinate(exitRow, exitCol);
                cells[coordinate.row()][coordinate.col()] = new Cell(coordinate, Type.END);
                break;
            }
        } while (true);
    }

    private boolean isValid(int newRow, int newCol, Cell[][] cells) {
        return newRow >= 0 && newRow < row
            && newCol >= 0 && newCol < col
            && cells[newRow][newCol].type() == Type.WALL;
    }

    @SuppressWarnings("MagicNumber")

    private void createWallsAndPassages(List<int[]> walls, Cell[][] cells) {
        while (!walls.isEmpty()) {
            int randomWallIndex = random.nextInt(walls.size());
            int[] wall = walls.get(randomWallIndex);
            walls.remove(randomWallIndex);
            int wallRow = wall[0];
            int wallCol = wall[1];
            List<Integer> directions = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
            Collections.shuffle(directions, random);
            for (int i = 0; i < 4; i++) {
                int newRow = wallRow + 2 * dx[i];
                int newCol = wallCol + 2 * dy[i];
                if (isValid(newRow, newCol, cells)) {
                    cells[newRow][newCol] = new Cell(new Coordinate(newRow, newCol), Type.PASSAGE);
                    cells[wallRow + dx[i]][wallCol + dy[i]]
                        = new Cell(new Coordinate(wallRow + dx[i], wallCol + dy[i]), Type.PASSAGE);
                    walls.add(new int[]{newRow, newCol});
                }
            }
        }
    }

    @SuppressWarnings("MagicNumber")
    @Override
    public Maze generateMaze() {
        if (row < 4 || row > 10000 || col < 4 || col > 10000) {
            throw new IllegalArgumentException("Enter sizes from 4 to 10000 to generate maze!");
        }
        Cell[][] cells = fillGrid();
        Cell startCell = getStartPoint(cells);
        List<int[]> walls = new ArrayList<>();
        walls.add(new int[]{startCell.coordinate().row(), startCell.coordinate().col()});
        createWallsAndPassages(walls, cells);
        markEndPoint(cells, startCell);
        return new Maze(row, col, cells);
    }
}
