package xiaohongshu;

import java.util.Scanner;
import java.util.Stack;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split("");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].equals("(") && !strs[i].equals(")") && !strs[i].equals("<")) {
                stack.push(strs[i]);
                continue;
            }

            else if (strs[i].equals("<")) {
                if (stack.isEmpty()) {
                    continue;
                }
                String str = stack.peek();
                if (!str.equals("(") && !str.equals(")")) {
                    stack.pop();
                }
            }

            else if (strs[i] .equals("(")) {
                stack.push(strs[i]);
            }
            else if (strs[i].equals(")")) {
                while (!stack.peek().equals("(")) {
                    stack.pop();
                }
                stack.pop();
            }
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        StringBuffer result = new StringBuffer();
        for (int i = sb.length() - 1; i >= 0; i--) {
            result.append(sb.charAt(i));
        }
        System.out.println(result);
    }
}
