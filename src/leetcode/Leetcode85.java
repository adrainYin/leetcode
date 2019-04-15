package leetcode;

import java.io.IOException;

public class Leetcode85 {

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int max = 0;
        int[][] dpMax = new int[rows][columns];
        //构造矩阵
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                //表示该结点为0
                if (matrix[j][i] - '0' == 0) {
                    dpMax[j][i] = 0;
                } else {
                    for (int k = i; k < columns; k++) {
                        if (matrix[j][k] - '0' == 1) {
                            dpMax[j][i] ++;
                        }
                        else {
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < columns; i++) {
            int[] heights = new int[rows];
            for (int j = 0; j < rows; j++) {
                heights[j] = dpMax[j][i];
            }

            int currMax = 0;
            int left;
            int right;
            for (int k = 0; k < heights.length; k++) {
                int currHeight = heights[k];
                left = right = k;
                while (left >= 0 && heights[left] >= currHeight) {
                    left --;
                }
                while (right < heights.length && heights[right] >= currHeight) {
                    right++;
                }
                int curr = currHeight * (right - left -1);
                currMax = Math.max(currMax, curr);
            }
            max = Math.max(max, currMax);
        }

        return max;
    }

    public static void main(String[] args) {
        char[][] chars = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        int max = maximalRectangle(chars);
        System.out.println(max);

    }

}
