package zijietiaodong;

import java.util.Scanner;
public class Main {


        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            String[] split = s.split(";");

            String num = split[0];

            int n = Integer.valueOf(split[1]);
            String[] numbers = num.split(",");
            long[] array = new long[numbers.length];
            for (int i = 0; i < array.length; i++) {
                array[i] = Long.valueOf(numbers[i]);
            }

            sort(array, 0, array.length - 1);

            for (int i = 0; i < n - 1; i++) {
                System.out.print(array[i] + ",");
            }
            System.out.print(array[n - 1]);

        }

        private static void sort(long[] array, int left, int right) {
            if (left >= right) {
                return;
            }
            int i = left, j = right;
            long temp = array[left];
            while (i < j) {
                while (compare(array[j], temp) >= 0 && i < j) {
                    j--;
                }
                while (compare(array[i], temp) <= 0 && i < j) {
                    i++;
                }
                if (i < j) {
                    long t = array[i];
                    array[i] = array[j];
                    array[j] = t;
                }
            }

            array[left] = array[i];
            array[i] = temp;

            sort(array, left, i - 1);
            sort(array, i + 1, right);

        }

        private static int compare(long b, long a) {

            if (a % 2 == 0 && b % 2 != 0) {
                return 1;
            }

            else if (a % 2 != 0 && b % 2 == 0) {
                return -1;
            }

            else {
                return Long.compare(a, b);
            }
        }
}
