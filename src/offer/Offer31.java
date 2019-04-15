package offer;

import java.util.Stack;

public class Offer31 {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        int left = 0;
        int right = 0;
        if (pushA.length == 0 && popA.length == 0) {
            return true;
        }
        if (pushA.length == 0 || popA.length != 0) {
            return false;
        }
        Stack<Integer> stack1 = new Stack<>();
        boolean isTrue = false;
        while (true) {
            while (left < pushA.length && pushA[left] != popA[right]) {
                stack1.push(pushA[left]);
                left ++;
            }
//            if (left >= pushA.length) {
//                return false;
//            }

            right ++;
            while (right < popA.length && !stack1.isEmpty() && stack1.peek() == popA[right]) {
                right ++;
                stack1.pop();
            }
            left ++;
            if (stack1.isEmpty() && left == pushA.length) {
                return true;
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[] pop = {4,5,3,2,1};
        System.out.println(IsPopOrder(nums, pop));
    }
}
