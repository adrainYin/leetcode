package exam58;

import java.util.Scanner;
import java.util.Stack;

public class Main2 {

    public static void main(String[] args) {
        char[] chars = {'0', '1','2','3','4','5','6','7','8','9','`','!','@','#','$','%','^','&','*','(',')','{','}','\\','<','>','?'};

        Scanner scanner = new Scanner(System.in);
        long nums = scanner.nextLong();

        Stack<Character> stack = new Stack<>();

        while (nums != 0) {
            int a = (int)(nums % 27);
            stack.push(chars[a]);
            nums = nums / 27;
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());

    }
}
