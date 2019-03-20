package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        if (matrix == null || rows ==0) {
            return list;
        }
        int columns = matrix[0].length;
        boolean[][] isVisited = new boolean[rows][columns];
        //初始化遍历的顺序
        int count = 0;
        int i = 0;
        int j = 0;
        while (count < (rows) * (columns)) {
            while (j < columns && !isVisited[i][j]) {
                list.add(matrix[i][j]);
                isVisited[i][j] = true;
                j ++;
                count++;
            }
            j--;
            i++;
            while (i < rows && !isVisited[i][j]) {
                list.add(matrix[i][j]);
                isVisited[i][j] = true;
                i++;
                count++;
            }
            i--;
            j--;
            while (j >= 0 && !isVisited[i][j]) {
                list.add(matrix[i][j]);
                isVisited[i][j] = true;
                j--;
                count++;
            }
            j++;
            i--;
            while (i >= 0 && !isVisited[i][j]) {
                list.add(matrix[i][j]);
                isVisited[i][j] = true;
                i--;
                count++;
            }
            i++;
            j++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
        System.out.println(spiralOrder(matrix));
    }
}
