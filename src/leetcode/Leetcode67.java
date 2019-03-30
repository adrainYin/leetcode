package leetcode;

/**
 * 模拟字符串的相加
 */
public class Leetcode67 {

    public  static String addBinary(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        char[] max_chars = charsA.length >= charsB.length ? charsA : charsB;
        char[] min_chars = charsA.length < charsB.length ? charsA : charsB;
        int max = Math.max(charsA.length, charsB.length);
        int min = Math.min(charsA.length, charsB.length);
        char[] chars = new char[max + 1];
        int index = 0;
        int overFlow = 0;
        while (index <= min - 1) {
            int A = charsA[charsA.length - 1 - index] - '0';
            int B = charsB[charsB.length - 1 - index] - '0';
            chars[chars.length - 1 - index] = (char)((A + B + overFlow) % 2 + '0');
            overFlow = (A + B + overFlow) / 2;
            index ++;
        }
        while (max - 1 - index >= 0){
            int tmp = max_chars[ max_chars.length - 1 - index] - '0';
            chars[chars.length - 1 - index] = (char) ((tmp + overFlow) % 2+ '0');
            overFlow = (tmp + overFlow) / 2;
            index ++;
        }
        chars[chars.length - 1 - index] = (char)(overFlow+ '0');

        if (chars[0] == '0') {
            return new String(chars).substring(1);
        } else {
            return new String(chars);
        }
    }
}
