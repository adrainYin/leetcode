package huaeri;

import java.io.IOException;
import java.util.Scanner;

public class Main3 {


    public static int sum = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");
        int[][] matrix = new int[Integer.valueOf(strs[0])][Integer.valueOf(strs[1])];
        int row = Integer.valueOf(strs[0]);
        int column = Integer.valueOf(strs[1]);

        for (int i = 0; i < row; i++) {
            String[] strings = scanner.nextLine().split(" ");
            for (int j = 0; j < column; j++) {
                matrix[i][j] = Integer.valueOf(strings[j]);
            }
        }
        int a_x = scanner.nextInt();
        int a_y = scanner.nextInt();
        int b_x = scanner.nextInt();
        int b_y = scanner.nextInt();

        boolean[][] isVisited = new boolean[row][column];
        int count =  canvisited(a_x, a_y, b_x, b_y, matrix, row, column, isVisited);
        System.out.println(count % 1000000000);

    }

//    private static int dfs(int[][] matrix, boolean[][] isVisited, int rows, int columns, int a_x, int a_y, int b_x, int b_y) {
//        return 0;
//    }

    private static int canvisited(int a_x, int a_y, int b_x, int b_y, int[][] matrix, int rows, int columns, boolean[][] isVisited) {
        int count = 0;


        if (a_x == b_x && a_y == b_y ) {
            return 1;
        }
        if (a_x -1 >= 0 && matrix[a_x-1][a_y] > matrix[a_x][a_y] && !isVisited[a_x-1][a_y]) {
//            isVisited[a_x-1][a_y] = true;
             count+= canvisited(a_x - 1, a_y, b_x, b_y, matrix, rows, columns, isVisited);
//            isVisited[a_x-1][a_y] = false;
        }
        if (a_x +1 < rows && matrix[a_x+1][a_y] > matrix[a_x][a_y] && !isVisited[a_x+1][a_y]) {
//            isVisited[a_x+1][a_y] = true;
             count += canvisited(a_x + 1, a_y, b_x, b_y, matrix, rows, columns, isVisited);
//            isVisited[a_x+1][a_y] = false;
        }
        if (a_y - 1 >= 0 && matrix[a_x][a_y - 1] > matrix[a_x][a_y] && !isVisited[a_x][a_y - 1]) {
//            isVisited[a_x][a_y - 1] = true;
            count += canvisited(a_x, a_y - 1, b_x, b_y, matrix, rows, columns, isVisited);
//            isVisited[a_x][a_y - 1] = false;
        }
        if (a_y + 1 < columns && matrix[a_x][a_y + 1] > matrix[a_x][a_y] && !isVisited[a_x][a_y + 1]) {
//            isVisited[a_x][a_y + 1] = true;
            count += canvisited(a_x, a_y + 1, b_x, b_y, matrix, rows, columns, isVisited);
//            isVisited[a_x][a_y = 1] = false;
        }

        return count;
    }
}
