package leetcode;

public class Leetcode59 {
    public static int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];
        boolean[][] isVisited = new boolean[n][n];
        int idx = 1;
        int i = 0, j = 0;
        while (idx < n * n + 1) {
            while (j < n && !isVisited[i][j]) {
                matrix[i][j] = idx++;
                isVisited[i][j] = true;
                j ++;
            }
            j --;
            i ++;
            while (i < n && !isVisited[i][j]) {
                matrix[i][j] = idx++;
                isVisited[i][j] = true;
                i++;
            }
            i --;
            j --;
            while (j >= 0 && !isVisited[i][j]) {
                matrix[i][j] = idx++;
                isVisited[i][j] = true;
                j--;
            }
            j ++;
            i --;
            while (i >= 0 && !isVisited[i][j]) {
                matrix[i][j] = idx++;
                isVisited[i][j] = true;
                i--;
            }
            i ++;
            j ++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        generateMatrix(3);
    }
}
