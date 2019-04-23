package leetcode;

public class Leetcode97 {

    public static boolean isInterleave(String s1, String s2, String s3) {
        int i = s1.length();
        int j = s2.length();
        int k = s3.length();
        //如果长度不同一定不能够组成
        if (i + j != k) {
            return false;
        }
        boolean[][] dp = new boolean[i + 1][j + 1];
        dp[0][0] = true;
        int index = 1;
        while (index <= i && s1.charAt(index - 1) == s3.charAt(index - 1)) {
            dp[index][0] = true;
            index ++;
        }
        index = 1;
        while (index <= j && s2.charAt(index - 1) == s3.charAt(index - 1)) {
            dp[0][index] = true;
            index ++;
        }
        for (int l = 1; l <= i; l++) {
            for (int m = 1; m <= j; m++) {
                dp[l][m] = (dp[l - 1][m] && s3.charAt(l + m - 1) == s1.charAt(l - 1)) ||
                        (dp[l][m - 1] && s3.charAt(l + m - 1) == s2.charAt(m - 1));
            }
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("", "", ""));
    }
}
