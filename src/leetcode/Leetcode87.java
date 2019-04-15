package leetcode;

public class Leetcode87 {

    private static boolean solution(String s1, int left1, int right1, String s2, int left2, int right2) {
        //如果长度不同直接返回false
        if (right1 - left1 != right2 - left2) {
            return false;
        }
        //表示分割成了一个字符,那么就判断是否相等
        if (left1 == right1) {
            return s1.charAt(left1) == s2.charAt(left2);
        }
        boolean flag = false;
        int[] tmp = new int[26];

        //剪枝处理，将统计出现的字符是否相同，不相同不用判断
        for (int i = left1; i <= right1; i++) {
            tmp[s1.charAt(i) - 'a'] ++;
        }
        for (int i = left2; i <= right2; i++) {
            if (tmp[s2.charAt(i) - 'a'] == 0) {
                return false;
            }
            tmp[s2.charAt(i) - 'a'] --;
        }
        for (int i = 0; i < right1 - left1 ; i++) {
             flag =  (solution(s1, left1, left1 + i, s2, left2, left2 + i) &&
                    solution(s1, left1 + i + 1, right1, s2, left2 + i + 1, right2)) ||
                    (solution(s1, left1, left1 + i, s2, right2 - i, right2) &&
            solution(s1, left1 + i + 1 , right1, s2, left2, right2 - i - 1));
             if (flag) {
                 break;
             }
        }
        return flag;
    }

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return solution(s1, 0, s1.length() - 1, s2, 0, s2.length() - 1);
    }

    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";
        System.out.println(solution(s1, 0, s1.length() - 1, s2, 0, s2.length() - 1));
        System.out.println(s1.substring(0, 1));
    }
}
