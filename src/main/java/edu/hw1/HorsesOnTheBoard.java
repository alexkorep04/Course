package edu.hw1;

public class HorsesOnTheBoard {
    private HorsesOnTheBoard() {
    }

    @SuppressWarnings("MagicNumber")

    private static boolean canKnightThreaten(int[][] board, int x, int y) {
        int[] dx = {-1, -1, 1, 1, -2, -2, 2, 2};
        int[] dy = {-2, 2, -2, 2, -1, 1, -1, 1};

        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                if (board[newX][newY] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @SuppressWarnings("MagicNumber")

    public static boolean canCapture(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && canKnightThreaten(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
