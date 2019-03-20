import java.util.Map;
import java.util.Scanner;

public class Tes1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs1 = scanner.nextLine().split(" ");
        int tmp = Integer.valueOf(strs1[1]);
//        scanner = new Scanner(System.in);
        String[] strs2 = scanner.nextLine().split(" ");

        int[] nums = new int[Integer.valueOf(strs1[1]) + 1];
//        int[] nums = new int[];
//        String[] strs2 = {"2","5","3","1","3","2","4","1","0","5","4","3"};
        for (int i = 0; i < strs2.length; i++) {
            int temp = Integer.valueOf(strs2[i]);
            nums[temp] ++;
        }
        boolean flag = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            System.out.println(-1);
        } else {
            System.out.println(solution(strs2, tmp , nums));
        }


    }


    public static int solution(String[]  strs, int num,int[] nums) {

        int i = 0;
        int j = strs.length - 1;
        int a = 0;
        int b = 0;

        while (i < j) {
            a = Integer.valueOf(strs[i]);
            b = Integer.valueOf(strs[j]);
            while (a == 0 ){
                i ++;
                a = Integer.valueOf(strs[i]);
            }
            while (b == 0) {
                j --;
                b = Integer.valueOf(strs[j]);
            }

            if ( (nums[a] == 1 || nums[b] == 1)) {
                break;
            }
            nums[a] --;
            nums[b] --;
            i++;
            j--;
        }
        //左边到头
        if (nums[a] == 1){

            while (i < j) {
                b = Integer.valueOf(strs[j]);
                while (b == 0) {
                    j --;
                    b = Integer.valueOf(strs[j]);
                }
                if (nums[b] == 1) {
                    break;
                }
                j --;
                nums[b] --;
            }
        } else {
            while (i < j) {
                a = Integer.valueOf(strs[i]);
                while (a == 0) {
                    i++;
                    a = Integer.valueOf(strs[i]);
                }
                if (nums[a] == 1){
                    break;
                }
                i ++;
                nums[a] --;
            }

        }
        return j - i + 1;
    }

}
