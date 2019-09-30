package tenguxn;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int hangshu = scanner.nextInt();
//        for (int i = 0; i < hangshu; i++) {
//            int nums = scanner.nextInt();
//            int[] num = new int[nums];
//            for (int j = 0; j < nums; j++) {
//                num[i] = scanner.nextInt();
//            }
//            solution(num);
//        }

        int[] nums = {5,9,4,7};
        solution(nums);
    }

    public static void solution(int[] nums) {


        int length = nums.length;
        int n = length / 2;
        int sum = 0;
        for (Integer integer : nums) {
            sum += integer;
        }

        boolean[][] flag = new boolean[n + 1][sum / 2 + 1];
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <= sum /2; j++) {
//                flag[i][j] = false;
//            }
//        }

        flag[0][0] = true;
        for (int i = 0; i <= 2 * n; i++) {
            for (int j = i > n ? n : i; j > 0 ; j--) {
                for (int k = 0; k <= sum / 2; k++) {
                    if (nums[i - 1] <= k && flag[j - 1][k - nums[i - 1]]) {
                        flag[j][k] = true;
                    }

                }
            }
        }

        int chazhi = 0;
        for (int i = sum   / 2; i > 0 ; i--) {
            if (flag[n][i]) {
                chazhi = sum - 2 * i;
            }
        }
        int x = (sum + chazhi) / 2;
        int y = sum - (sum + chazhi) / 2;
        System.out.println(Math.min(x,y) + " " + Math.max(x,y));




//        flag[0][0] = true;
//
//        int z ;
//        for (int i = 0; i < length; i++) {
//            for (z = i > n ? n : i; z >=1; z --) {
//                for (int j = 0; j <= sum / 2; j++) {
//                    if (j >= nums[i] && flag[z - 1][j - nums[i]]) {
//                        flag[z][j] = true;
//                    }
//                }
//            }
//        }
//        int chazhi = 0;
//
//        for (int i = sum / 2; i >= 0; i--) {
//            if (flag[n][i]) {
//                chazhi = sum -2 * i;
//            }
//        }
//        int x = (sum + chazhi) / 2;
//        int y = sum - (sum + chazhi) / 2;
//        System.out.println(Math.min(x,y) + " " + Math.max(x,y));
    }
}
