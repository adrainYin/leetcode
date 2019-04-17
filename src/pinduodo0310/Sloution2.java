package pinduodo0310;

import java.util.Arrays;
import java.util.Scanner;

public class Sloution2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int[] h = new int[num];
        for (int i = 0; i < num; i++) {
            h[i] = scanner.nextInt();
        }
        int w_num = scanner.nextInt();
        int[] w = new int[w_num];
        for (int i = 0; i < w_num; i++) {
            w[i] = scanner.nextInt();
        }
        Arrays.sort(w);
        Arrays.sort(h);
        int count = 0;
        int a = 0;
        int b = 0;
        while (a < h.length && b < w.length) {
            //可以分配
            if (h[a] <= w[b]) {
                count += 1;
                a++;
                b++;
            } else {
                b ++;
            }
        }
        System.out.println(count);


    }
}
