package leetcode;

public class Leetcode3 {


    /**
     * 寻找最长的不重复子串，用滑动窗口法。
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        int length = 1;
        int left = 0;
        if (s.length() == 0 || s == null){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            int curr_length = 1;
            int j = i - 1;
            while (j >= left){
                if (chars[j] != chars[i]){
                    curr_length ++;
                }
                else {
                    left = j + 1;
                    length = curr_length > length ? curr_length : length;
                    break;
                }
                j -- ;
            }
            if (j < left){
                length = curr_length > length ? curr_length : length;
            }

        }
        return length;
    }

    public static void main(String[] args) {
        String string = "bbbbb";
        System.out.println(lengthOfLongestSubstring(string));
    }
}
