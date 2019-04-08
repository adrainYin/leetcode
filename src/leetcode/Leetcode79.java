package leetcode;

public class Leetcode79 {

    public static boolean exist(char[][] board, String word) {
        if (word == null || word.equals("")) {
            return true;
        }
        if (board == null || board.length == 0) {
            return false;
        }
        int rows = board.length;
        int columns = board[0].length;
        boolean[][] isVisited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (canVisited(board, word, 0, i, j, isVisited, rows, columns)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean canVisited(char[][] board, String word, int currIndex, int row, int column, boolean[][] isVisited, int rows, int columns) {
        if (currIndex > word.length() - 1) {
            return true;
        }
        if (row < 0 || row > rows - 1 || column < 0 || column > columns - 1 || isVisited[row][column] || board[row][column] != word.charAt(currIndex)) {
            return false;
        }
        boolean flag = false;
        isVisited[row][column] = true;
        flag = canVisited(board, word, currIndex + 1, row - 1, column, isVisited, rows, columns) ||
                canVisited(board, word, currIndex + 1, row + 1, column, isVisited, rows, columns) ||
                canVisited(board, word, currIndex + 1, row, column - 1, isVisited, rows, columns) ||
                canVisited(board, word, currIndex + 1, row, column + 1, isVisited, rows, columns);
        isVisited[row][column] = false;
        return flag;
    }

    public static void main(String[] args) {

    }
}
