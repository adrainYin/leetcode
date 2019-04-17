package offer;

import java.util.Stack;

public class Offer31 {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        int left = -1;
        int right = 0;
        if (pushA.length == 0 && popA.length == 0) {
            return true;
        }
        if (pushA.length == 0) {
            return false;
        }
        if (popA.length == 0) {
            return false;
        }
        if (pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        while ( right < popA.length) {
            if (stack.isEmpty() || stack.peek() != popA[right]) {
                left += 1;
                if (left >= pushA.length) {
                    return false;
                }
                stack.push(pushA[left]);
            }
            else {
                stack.pop();
                right ++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[] pop = {5,4,3,2,1};
        System.out.println(IsPopOrder(nums, pop));
    }
}
