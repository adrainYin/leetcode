package EA;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String[] keys = new String[n];

        for (int i = 0; i < n; i++) {
            keys[i] = scanner.next();
        }

        int m = scanner.nextInt();
        String[] plays = new String[m];
        for (int i = 0; i < m; i++) {
            plays[i] = scanner.next();
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            int length1 = keys[i].length();
            for (int j = 0; j < m; j++) {
                int length2 = plays[j].length();

                if (length2 >= length1 && keys[i].equals(plays[j].substring(0, length1))) {
                    count ++;
                }
            }
            System.out.println(count);
        }
    }
}
