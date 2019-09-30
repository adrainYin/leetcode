//package xiaohongshu;
//
//import java.util.Scanner;
//
//public class Main {
//
//    public  int[][] next = {{0,1}, {1,0}, {0,-1}, {-1, 0}};
//    int total = Integer.MAX_VALUE;
//
//
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int k = scanner.nextInt();
//        int[][] dp = new int[n][m];
//        boolean[][] isVisited = new boolean[n][m];
//        boolean[][] zhangai = new boolean[n][m];
//        for (int i = 0; i < k; i++) {
//            int row = scanner.nextInt();
//            int column = scanner.nextInt();
//            zhangai[row][column] = true;
//        }
//
//        if (zhangai[0][0]) {
//            System.out.println(0);
//        }
//
//        int result = dfs(n - 1, m - 1, isVisited, zhangai, 0, 0, 0);
//        System.out.println(result);
//
//
//
//    }
//
//    private  void dfs(int row, int column, boolean[][] isVisited, boolean[][] zhangai, int currRow, int currColumn, int min) {
//
//        if (currRow == row && currColumn == column) {
//            if (min < total) {
//                total = min;
//                return ;
//            }
//        }
//        for (int i = 0; i < 4; i++) {
//            int nx = currRow + next[i][0];
//            int ny = currColumn + next[i][1];
//            if (nx < 1 || nx > row || ny < 1 || ny > column) {
//                continue;
//            }
//            ?
//        }
//    }
//
//    private static boolean isCanVisited(int row, int column, boolean[][] isVisited, boolean[][] zhangai, int currRow, int currColumn) {
//
//        if (currRow > row || currRow < 0 || currColumn > column || currColumn < 0 || isVisited[row][column] || zhangai[row][column]) {
//            return false;
//        }
//        return true;
//    }
//}
