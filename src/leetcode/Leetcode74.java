package leetcode;

public class Leetcode74 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int rowsIndex = 0;
        int columnsIndex = columns - 1;
        while (columnsIndex >= 0 && rowsIndex <= rows - 1) {
            if (matrix[rowsIndex][columnsIndex] == target) {
                return true;
            } else if (matrix[rowsIndex][columnsIndex] < target) {
                rowsIndex ++;
            } else {
                columnsIndex --;
            }
        }
        return false;

    }
}
