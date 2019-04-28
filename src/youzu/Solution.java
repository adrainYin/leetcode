package youzu;

import java.util.Scanner;


/**
 * 游族杯最后一道题，丽娃河的座位分配问题
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            int[] nums = new int[6];
            for (int j = 0; j < nums.length; j++) {
                nums[j] = scanner.nextInt();
            }
            int count = 0;
            count += nums[5];
            //人数5的处理
            if (nums[0] >= nums[4]) {
                count += nums[4];
                nums[0] -= nums[4];
            }
            else {
                count += nums[4];
                nums[0] = 0;
            }
            //人数4的处理
            count += nums[3];
            if (nums[1] >= nums[3]) {
                nums[1] -= nums[3];
            }
            else {
                int temp = nums[3] - nums[1];
                nums[1] = 0;
                //剩余没有补全的人数
                //补充人数为1的队伍，如果补充不了就空闲
                if (nums[0]  >= temp *2 ) {
                    nums[0] -= temp * 2;
                }
                else {
                    nums[0] = 0;
                }
            }
            //考虑人数为3的队伍
            count += nums[2] / 2;
            //如果有多余的队伍，那么数量一定是1
            if (nums[2] % 2 != 0) {
                //安排
                count += 1;
                //坐满
                if (nums[0] != 0 && nums[1] != 0) {
                    nums[0] --;
                    nums[1] --;
                }else if (nums[1] == 0 && nums[0] != 0) {
                    nums[0] = nums[0] - 3 >= 0 ? nums[0] - 3 : 0;
                }
                else if (nums[1] != 0) {
                    nums[1] -= 1;
                }
            }
            //安排人数为2的队伍
            count += nums[1] / 3;
            //有多余的队伍
            if (nums[1] % 3 != 0) {
                count += 1;
                //需要从1的队伍中补人数
                int need = 6 - nums[1] % 3 * 2;
                if (nums[0] >= need) {
                    nums[0] -= need;
                }
                else {
                    nums[0] = 0;
                }
            }
            count += nums[0] / 6;
            if (nums[0] % 6 != 0) {
                count += 1;
            }
            System.out.println(count);

        }
    }
}
