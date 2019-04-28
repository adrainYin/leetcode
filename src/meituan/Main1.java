package meituan;


import java.util.*;

/**
 * 我们称一个矩阵为黑白矩阵，当且仅当对于该矩阵中每一个位置如(i,j),其上下左右四个方向的数字相等，
 * 即(i-1,j),(i+1,j),(i,j+1),(i,j-1)四个位置上的数字两两相等且均不等于(i,j)位置上的数字。(超出边界的格子忽略)
 *
 * 现在给出一个n*m的矩阵，我们想通过修改其中的某些数字，使得该矩阵成为黑白矩阵，问最少修改多少个数字。
 *
 * 输入
 * 第一行包含两个整数n,m,表示矩阵的长宽。(1≤n,m≤100000,1≤n*m≤100000)。
 *
 * 接下来有n行，每行包含m个整数，中间用空格隔开，表示n*m的矩阵。
 *
 * 输出
 * 输出仅包含一个数字，表示该矩阵想修改为黑白矩阵最少修改的数字数量。
 *
 *
 * 样例输入
 * 3 3
 * 1 1 1
 * 1 1 1
 * 1 1 1
 * 样例输出
 * 4
 *
 * 提示
 * 补充样例
 * 输入样例2
 * 3 3
 * 1 1 1
 * 1 5 1
 * 1 1 1
 * 输出样例2
 * 4
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[] count = new int[1000001];
        Map<Integer, Integer> map = new HashMap<>();
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int temp = scanner.nextInt();
                matrix[i][j] = temp;
                count[temp] ++;
                if (!map.containsKey(temp)) {
                    map.put(temp, 0);
                }
                map.put(temp, map.get(temp) + 1);
            }
        }
        int max = 0;
        int maxNum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < count.length; i++) {
            if (count[i] != 0) {
                list.add(i);
            }
        }
        if (list.size() == 1) {
            System.out.println(rows * columns / 2);
            return;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int currMin = Integer.MAX_VALUE;
                int currcount = 0;
                int a = list.get(i);
                int b = list.get(j);
                for (int k = 0; k < rows; k++) {
                    for (int l = 0; l < columns; l++) {
                        if ((k + l) % 2 == 0 && matrix[k][l] != a) {
                            currcount ++;
                        }
                        if ((k + l) % 2 == 1 && matrix[k][l] != b) {
                            currcount ++;
                        }
                    }
                }
                currMin = Math.min(currMin, currcount);
                currcount = 0;
                for (int k = 0; k < rows; k++) {
                    for (int l = 0; l < columns; l++) {
                        if ((k + l) % 2 == 0 && matrix[k][l] != b) {
                            currcount ++;
                        }
                        if ((k + l) % 2 == 1 && matrix[k][l] != a) {
                            currcount ++;
                        }
                    }
                }
                currMin = Math.min(currMin, currcount);
                min = Math.min(currMin, min);
            }
        }
        System.out.println(min);

    }
}
