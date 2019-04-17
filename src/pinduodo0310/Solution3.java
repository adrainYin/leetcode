package pinduodo0310;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution3 {



    static class Node {
        int x;
        int y;
        int key;
        int length;

        public Node(int x, int y, int key, int length) {
            this.x = x;
            this.y = y;
            this.key = key;
            this.length = length;
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");
        int rows = Integer.valueOf(strs[0]);
        int columns = Integer.valueOf(strs[1]);
        char[][] migong = new char[rows][columns];

        //定义临时的字母boolean
        boolean[] yaoshi = new boolean[26];
        int x = 0;
        int y = 0;
        for (int i = 0; i < rows; i++) {
            char[] tmp = scanner.nextLine().toCharArray();
            for (int j = 0; j < tmp.length; j++) {
                migong[i][j] = tmp[j];
                if (tmp[j] - '0' == 2) {
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(bfs(migong, rows, columns, x, y));

    }

    /**
     * 使用bfs搜寻最短路径。如果第一次遍历到，那么一定就是最短的。
     * @return
     */
    private static int bfs(char[][] migong, int rows, int columns, int x, int y) {
        //判断当前状态是否已经访问过
        boolean[][][] isVisited = new boolean[rows][columns][1024];
        //初始化钥匙的状态
        isVisited[x][y][0] = true;
        int[][] next = {{0,1}, {1,0}, {0,-1}, {-1, 0}};
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < next.length; i++) {
                int next_X = node.x + next[i][0];
                int next_y = node.y + next[i][1];
                if (next_X < 0 || next_X >= rows || next_y < 0 || next_y >= columns ||migong[next_X][next_y] - '0' == 0) {
                    continue;
                }
                //到达终点，直接返回。无权值的终点一定是最小的
                if (migong[next_X][next_y] - '0' == 3) {
                    return node.length + 1;
                }
                int key = node.key;
                if ('a' <=migong[next_X][next_y] && migong[next_X][next_y] <= 'z') {
                    key = key | 1 << migong[next_X][next_y] - 'a';
                }
                else if ('A' <=migong[next_X][next_y] && migong[next_X][next_y] <= 'Z') {
                    //如果没有钥匙
                    if ((1 << migong[next_X][next_y] - 'A' & key) == 0) {
                        continue;
                    }
                }
                if (!isVisited[next_X][next_y][key]) {
                    isVisited[next_X][next_y][key] = true;
                    queue.offer(new Node(next_X, next_y, key, node.length + 1));
                }
            }
        }
        return 0;
    }
}



