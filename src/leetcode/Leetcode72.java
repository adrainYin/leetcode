package leetcode;

public class Leetcode72 {

    public static int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) {
            return Math.max(word1.length(), word2.length());
        }

        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= length2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                int insert = dp[i - 1][j] + 1;
                int delete = dp[i][j - 1] + 1;
                int update = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i-1][j-1] : dp[i - 1][j - 1] + 1;

                dp[i][j] = Math.min(Math.min(insert, delete), update);
            }
        }
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }
}
