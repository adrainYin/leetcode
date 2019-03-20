package leetcode;

public class Leetcode45 {


    //逆序最优，时间为O(n2)
//    public static int jump(int[] nums) {
//        int length = nums.length;
//        int[] minJump = new int[length];
//        minJump[0] = 0;
//
//        for (int i = 1; i < minJump.length; i++) {
//            int min = Integer.MAX_VALUE;
//            for (int j = i - 1; j >=0 ; j--) {
//                //表示跳跃不到
//                if (nums[j] + j < i) {
//                    continue;
//                }
//                min = minJump[j] + 1 < min ? minJump[j] + 1 : min;
//            }
//            minJump[i] = min;
//        }
//        return minJump[minJump.length - 1];
//    }

    /**
     * 用贪心法，每次到的地方是下次能到达的最远地方，因为其中最远的地方一定会包括进去。
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int length = nums.length;
        int next = 0;
        int nextStepLength = nums[0];
        int step = 0;
        while (next + nextStepLength <= nums.length - 1) {
            if (nextStepLength != 0) {
                int reach = next;
                int tempReach = next;
                for (int i = 1; i <= nextStepLength; i++) {
                    int temp = next + i + nums[next + i];
                    if (temp > reach) {
                        tempReach = next + i;
                        reach = temp;

                    }
                }
                next = tempReach;
                step ++;
                nextStepLength = nums[next];
            }
        }
        return step;
    }


    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }


}
