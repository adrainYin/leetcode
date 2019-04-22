package wangyi.wangyi2018;

import java.util.Scanner;

/**
 * 题目描述
 * 牛牛又从生物科研工作者那里获得一个任务,这次牛牛需要帮助科研工作者从DNA序列s中找出最短没有出现在DNA序列s中的DNA片段的长度。
 * 例如:s = AGGTCTA
 * 序列中包含了所有长度为1的('A','C','G','T')片段,但是长度为2的没有全部包含,例如序列中不包含"AA",所以输出2。
 * 输入描述:
 * 输入包括一个字符串s,字符串长度length(1 ≤ length ≤ 2000),其中只包含'A','C','G','T'这四种字符。
 * 输出描述:
 * 输出一个正整数,即最短没有出现在DNA序列s中的DNA片段的长度。
 *
 * 示例1
 * 输入
 * AGGTCTA
 *
 * 输出
 * 2
 */
public class Solution8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] chars = str.toCharArray();
        int A = getShortSubString(chars, 'A');
        int G = getShortSubString(chars, 'G');
        int C = getShortSubString(chars, 'C');
        int T = getShortSubString(chars, 'T');
        if (A == G && G == C && C == T) {
            System.out.println(A + 1);
            return;
        }
        int shortest = Math.min(Math.min(Math.min(A, G), C), T);
        System.out.println(shortest + 1);

    }

    private static int getShortSubString(char[] chars,  char c) {
        int length = 0;
        int curr = 0;
        while (curr < chars.length) {
            if (chars[curr] == c) {
                int currLength = 0;
                while (curr < chars.length && chars[curr] == c) {
                    currLength += 1;
                    curr ++;
                }
                length = Math.max(length, currLength);
                curr --;
            }
            curr ++;
        }
        return length;
    }
}
