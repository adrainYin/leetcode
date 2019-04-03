package leetcode;

public class Leetcode73 {

    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 ){
            return ;
        }
        
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] isZero = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0) {
                    isZero[i][j] = true;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0 && isZero[i][j]) {
                    for (int k = 0; k < columns; k++) {
                        matrix[i][k] = 0;
                    }
                    for (int k = 0; k < rows; k++) {
                        matrix[k][j] = 0;
                    }
                }
            }
        }
    }
}
