package wangyi.wangyi2018;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 小易老师是非常严厉的,它会要求所有学生在进入教室前都排成一列,并且他要求学生按照身高不递减的顺序排列。
 * 有一次,n个学生在列队的时候,小易老师正好去卫生间了。学生们终于有机会反击了,于是学生们决定来一次疯狂的队列,
 * 他们定义一个队列的疯狂值为每对相邻排列学生身高差的绝对值总和。由于按照身高顺序排列的队列的疯狂值是最小的,
 * 他们当然决定按照疯狂值最大的顺序来进行列队。现在给出n个学生的身高,请计算出这些学生列队的最大可能的疯狂值。
 * 小易老师回来一定会气得半死。
 *
 * 5
 * 5 10 25 40 25
 */
public class Solution5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] nums = new int[num];
        boolean[] flag = new boolean[num];
        for (int i = 0; i < num; i++) {
            nums[i] = scanner.nextInt();
        }

        Arrays.sort(nums);
        //定义最小的
        flag[0] = true;
        int max = 0;
        int left = 0; int right = 0;
        for (int i = 1; i < num; i++) {
            int lmax = -1;
            int rmax = -1;
            int lidx = -1;
            int ridx = -1;
            for (int j = 1; j < num; j++) {
                if (!flag[j] && Math.abs(nums[j] - nums[left]) > lmax) {
                    lmax = Math.abs(nums[j] - nums[left]);
                    lidx = j;
                }
            }
            for (int j = 1; j < num; j++) {
                if (!flag[j] && Math.abs(nums[j] - nums[right]) > rmax) {
                    rmax =  Math.abs(nums[j] - nums[right]);
                    ridx = j;
                }
            }
            //左边的大，优先进行排序
            if (lmax >= rmax) {
                max += Math.abs(nums[lidx] - nums[left]);
                left = lidx;
                flag[lidx] = true;
            }
            else {
                max += Math.abs(nums[ridx] - nums[right]);
                right = ridx;
                flag[ridx] = true;
            }
        }
        System.out.println(max);
    }
}
