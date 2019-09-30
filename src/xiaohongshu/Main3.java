package xiaohongshu;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] X = new int[num];
        int[] H = new int[num];
        for (int i = 0; i < num; i++) {
            X[i] = scanner.nextInt();
            H[i] = scanner.nextInt();
        }

        int init_X = 0;
        int init_H = 0;
        int total = 0;
        for (int i = 0; i < num; i++) {
            if (X[i] >= init_X && H[i] >= init_H) {
                total += 1;
                init_X = X[i];
                init_H = H[i];
            }
        }
        System.out.println(total);

    }
}
