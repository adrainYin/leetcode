package souhu;


import java.util.Scanner;

/**
 * 工厂生产的产品包装在相同高度h，尺寸为1 * 1,2 * 2，3 * 3，4 * 4，5 * 5，6 * 6的方形包装中。
 * 这些产品始终以与产品高度相同的尺寸为6 * 6的包裹交付给客户。
 * 因为邮费很贵，所以工厂要想方设法的减小每个订单运送时的包裹数量。他们很需要有一个好的程序帮他们解决这个问题从而节省费用。
 * 现在这个程序由你来设计。
 *
 * 输入描述:
 * 输入文件包括几行，每一行代表一个订单。每个订单里的一行包括六个整数，中间用空格隔开，分别为 1*1 至 6*6 这六种产品的数量。输入文件将以 6 个 0 组成的一行结尾。
 * 输出描述:
 * 除了输入的最后一行 6 个 0 以外，输入文件里每一行对应着输出文件的一行，每一行输出一个整数代表对应的订单所需的最小包裹数。
 *
 *
 *
 * 输入

 * 0 0 4 0 0 1
 * 7 5 1 0 0 0
 * 0 0 0 0 0 0
 * 输出

 * 2
 * 1
 */

public class Solution1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] strs = scanner.nextLine().split(" ");
            int[] nums = new int[6];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.valueOf(strs[i]);
            }
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                count += nums[i];
            }
            if (count == 0) {
                break;
            }
            //如果不是最后一行
            doPackage(nums);

        }
    }

    public static void doPackage(int[] nums) {
        int num = 0;
        num += nums[5];
        num += nums[4];
        //有11个长度为1的空余
        if (nums[4] != 0) {
            if (nums[0] >= nums[4] * 11) {
                nums[0] -= nums[4] * 11;
            } else {
                nums[0] = 0;
            }
        }
        num += nums[3];
        //有20个空余 可以装填20个1 * 1或者5个2 * 2
        if (nums[3] != 0) {
            if (nums[1] >= nums[3] * 5) {
                nums[1] -= nums[3] * 5;
            }
            else {
                int res = nums[3] * 20 - nums[1] * 4;
                nums[1] = 0;
                if (nums[0] >= res) {
                    nums[0] -= res;
                }else {
                    nums[0] = 0;
                }
            }
        }
        num += nums[2] / 4;
        //有多余的3 * 3 不能放下，需要用新的包裹
        if (nums[2] % 4 != 0) {
            num += 1;
            //剩余的 3 * 3的大小
            int res = 4 - nums[2] % 4;

        }

    }
}
