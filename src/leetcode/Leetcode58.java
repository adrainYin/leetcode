package leetcode;

public class Leetcode58 {

    public  static int lengthOfLastWord(String s) {
        if (s == null || s.equals(" ")) {
            return 0;
        }
        char[] chars = s.toCharArray();

        int i = chars.length - 1;
        int count = 0;
        while (i >= 0 && chars[i] == ' ') {
            i--;
        }
        while (i >= 0 && chars[i] != ' ') {
            count ++;
            i --;
        }
        return count;
    }
}
