package baidu;

import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nums = scanner.nextInt();
        for (int i = 0; i < nums; i++) {
            int p = scanner.nextInt();
            int w = scanner.nextInt();

            int[][] array = new int[w][2];

            for (int j = 0; j < w; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                array[j][0] = Math.min(a,b);
                array[j][1] = Math.max(a,b);
            }
            solution(p,w, array);


        }
    }

    public static void solution(int p, int w, int[][] array) {

        //记录位置
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            if (array[i][0] == 1) {
                list.add(i);
                if (array[i][1] == p) {
                    System.out.println("POSSIBLE");
                    return;
                }
            }
        }

        if (list.isEmpty()) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        for (Integer i : list) {
            int x = array[i][1];
            for (int j = 0; j < w; j++) {
                if (array[j][0] == x && array[j][1] == p) {
                    System.out.println("POSSIBLE");
                    return;
                }
            }
        }
        System.out.println("IMPOSSIBLE");

    }
}
