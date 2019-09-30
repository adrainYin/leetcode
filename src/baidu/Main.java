package baidu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();



        int min = Integer.MAX_VALUE;


        for (int a = n; a >=0; a--) {
            for (int b =m;b >= 0; b--) {
                if ((n -a) * (m - b) <= k) {
                    min = min < (a + b) ?min : a+ b;

                }
            }
        }
        System.out.println(min);
    }
}
