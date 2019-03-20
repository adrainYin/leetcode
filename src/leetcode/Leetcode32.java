package leetcode;

import java.util.Stack;

public class Leetcode32 {

    /**
     * 方法不正确
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        if (s.length() == 0){
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        int max = 0;
        int curr_length = 0;
        char[] strs = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (strs[i] == '('){
                stack.push(strs[i]);
            }
            if (strs[i] == ')' && !stack.empty()){
                stack.pop();
                curr_length += 2;
                max = curr_length > max ? curr_length : max;
            }
            else if (strs[i] == ')' && stack.empty()){
                 curr_length = 0;
            }
        }
        return max;
    }

    public static int method(String s) {
        if (s.length() == 0){
            return 0;
        }
        char[] strs = s.toCharArray();
        int max = 0;
        int start = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == '('){
                stack.push(i);
            }
            else {
                if (stack.empty()){
                    start = i + 1;
                }
                else {
                    int index = stack.pop();
                    if (stack.empty()){
                        max = Math.max(max, i - start + 1);
                    }
                    else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "()(()";
        System.out.println(method(s));
    }
}
