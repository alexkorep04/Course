package edu.project2.prettyprint;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import edu.project2.Type;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrettyPrint {
    private final static Logger LOGGER = LogManager.getLogger();
    private final char whiteRectangle = '\u25A0';

    private void changeTypeToSymbol(Cell cell, StringBuilder stringBuilder) {
        if (cell.type() == Type.PASSAGE) {
            stringBuilder.append(' ');
        } else if (cell.type() == Type.WALL) {
            stringBuilder.append(whiteRectangle);
        } else if (cell.type() == Type.START) {
            stringBuilder.append('S');
        } else if (cell.type() == Type.END) {
            stringBuilder.append('E');
        } else {
            stringBuilder.append('+');
        }
    }

    private void fillGridWithSymbols(Maze maze) {
        StringBuilder stringBuilder;
        for (int i = 0; i < maze.getHeight(); i++) {
            stringBuilder = new StringBuilder();
            for (int j = 0; j < maze.getWidth(); j++) {
                changeTypeToSymbol(maze.getGrid()[i][j], stringBuilder);
            }
            LOGGER.info(stringBuilder.toString());
        }
    }

    private Coordinate findStartPoint(Maze maze) {
        Coordinate start = null;
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                if (maze.getGrid()[i][j].type() == Type.START) {
                    start = new Coordinate(i, j);
                }
            }
        }
        return start;
    }

    private Coordinate findEndPoint(Maze maze) {
        Coordinate end = null;
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                if (maze.getGrid()[i][j].type() == Type.END) {
                    end = new Coordinate(i, j);
                }
            }
        }
        return end;
    }

    public void printMaze(Maze maze) {
        LOGGER.info("Generated maze: ");
        Coordinate start = findStartPoint(maze);
        Coordinate end = findEndPoint(maze);
        fillGridWithSymbols(maze);
    }

    private void markPath(List<Coordinate> path, Maze maze, Coordinate start, Coordinate end) {
        for (Coordinate point : path) {
            if (!((point.row() == start.row() && point.col() == start.col())
                || (point.row() == end.row() && point.col() == end.col()))) {
                maze.getGrid()[point.row()][point.col()] = new Cell(point, Type.PATH);
            }
        }
    }

    public void printPath(Maze maze, List<Coordinate> path, Coordinate start, Coordinate end) {
        if (path != null) {
            LOGGER.info("Path found:");
            markPath(path, maze, start, end);
            fillGridWithSymbols(maze);
        } else {
            LOGGER.info("Path not found.");
        }
    }
}
