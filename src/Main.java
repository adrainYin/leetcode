import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] str1 = scanner.nextLine().split("");
        scanner = new Scanner(System.in);
        String[] str2 = scanner.nextLine().split("");

        Stack<String> result = new Stack<>();
        BigInteger integer = new BigInteger("0");

        System.out.println(compute(0, str1, str2, 0, 0, result));

    }


    public static long compute(long integer, String[] strs1, String[] strs2, int index1, int index2, Stack<String> stack) {
        if (index1 == strs1.length && index2 == strs2.length) {
            return 1;
        }

        if (index1 == strs1.length) {
            if (strs2[index2].equals("(")) {
                stack.push("(");
                return integer + compute(integer, strs1, strs2, index1, index2 + 1, stack);
            } else {
                if (stack.isEmpty()) {
                    return integer;
                } else {
                    stack.pop();
                    return integer + (compute(integer, strs1, strs2, index1, index2 + 1, stack));
                }
            }

        } else if (index2 == strs2.length) {
            if (strs1[index1].equals("(")) {
                stack.push("(");
                return integer + (compute(integer, strs1, strs2, index1 + 1, index2, stack));
            } else {
                if (stack.isEmpty()) {
                    return integer;
                } else {
                    stack.pop();
                    return integer + (compute(integer, strs1, strs2, index1 + 1, index2, stack));
                }
            }
        } else {
            if (strs1[index1].equals("(")) {
                stack.push("(");
                integer += (compute(integer, strs1, strs2, index1 + 1, index2, stack));
            } else if (strs1[index1].equals(")")) {
                if (stack.isEmpty()) {
                    return integer;
                } else {
                    stack.pop();
                    integer += (compute(integer, strs1, strs2, index1 + 1, index2, stack));
                }
            }

            if (strs2[index2].equals("(")) {
                stack.push("(");
                integer += (compute(integer, strs1, strs2, index1, index2 + 1, stack));
            } else if (strs2[index2].equals(")")){
                if (stack.isEmpty()) {
                    return integer;
                } else {
                    stack.pop();
                    integer += (compute(integer, strs1, strs2, index1, index2 + 1, stack));
                }
            }
            return integer;
        }
    }
}
