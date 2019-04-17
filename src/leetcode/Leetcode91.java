package leetcode;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 */
public class Leetcode91 {

    public static int numDecodings(String s) {

        int pre2 = 1; int pre1 = 1; int ans;
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        if (chars[0] - '0' == 0) {
            return 0;
        }
        for (int i = 1; i < chars.length; i++) {
            ans = 0;
            int num = (chars[i - 1] - '0') * 10 + chars[i] - '0';
            if (chars[i] - '0' == 0) {  //表示当前为0，需要判断之前的是否为1或者2
                if (chars[i - 1] - '0' != 1 && chars[i - 1] - '0' != 2) {
                    return 0;
                }
                ans += pre2;
            }
            else {
                ans += pre1;
                if (num > 10 && num < 27) {
                    ans += pre2;
                }
            }
            pre2 = pre1;
            pre1 = ans;
        }
        return pre1;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("301"));
    }
}
