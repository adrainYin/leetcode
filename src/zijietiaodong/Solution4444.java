package zijietiaodong;
import java.util.Scanner;

public class Solution4444 {


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            float[] array = new float[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            float max = 0;
            for (int i = 0; i < n; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }


            //算i的概率
            float[] possbile = new float[(int) max + 1];

            possbile[1] = 1;
            for (int i = 0; i < array.length; i++) {
                possbile[1] *= (1 / array[i]);
            }
            for (int i = 2; i <= max; i++) {
                possbile[i] = 1;
                //计算最大为该值的概率
                for (int j = 0; j < array.length; j++) {
                    if (array[j] > i) {
                        possbile[i] *= (i / array[j]);
                    }
                }
                for (int j = 1; j < i; j++) {
                    possbile[i] -= possbile[j];
                }
            }

            float result = 0;
            for (int i = 1; i <= max; i++) {
                result += i * possbile[i];
            }

            System.out.printf("%.2f", result);

        }
}
