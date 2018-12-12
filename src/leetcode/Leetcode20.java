package leetcode;

import java.util.Stack;

public class Leetcode20 {

    public static boolean isValid(String s) {
        if (s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if (c == ')'){
                if (stack.empty()){
                    return false;
                }
                char temp = stack.pop();
                if (temp != '('){
                    return false;
                }
            }else if (c == '}'){
                if (stack.empty()){
                    return false;
                }
                char temp = stack.pop();
                if (temp != '{'){
                    return false;
                }
            } else if (c == ']'){
                if (stack.empty()){
                    return false;
                }
                char temp = stack.pop();
                if (temp != '['){
                    return false;
                }
            } else {
                return false;
            }
        }

        if (stack.empty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(isValid(s));
    }
}
