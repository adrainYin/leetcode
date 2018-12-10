package leetcode;

public class Leetcode5 {

    /**
     * O(n2)的算法，用双指针遍历。这个算法是不对的，因为需要找到的是回文，而不是
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s.length() == 0 || s == null){
            return "";
        }
        char[] chars = s.toCharArray();
        int max_length = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < chars.length; i++) {
            for (int j = chars.length - 1; j>= i; j --){
                if (chars[i] == chars[j]){
                     int curr_length = j - i + 1;
                    if (curr_length > max_length){
                        max_length = curr_length;
                        start = i;
                        end = j;
                        break;
                    }
                }
            }
            if (max_length >= s.length() - i){
                break;
            }
        }
        return s.substring(start, end + 1);

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babecbad"));
        System.out.println(String.valueOf(121));
    }
}
