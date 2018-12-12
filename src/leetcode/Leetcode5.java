package leetcode;

public class Leetcode5 {

    /**
     * O(n2)的算法，用双指针遍历。这个算法是不对的，因为需要找到的是回文，而不是
     * 没有做完
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

    public static String method(String s){
        if (s.length() == 0 || s == null){
            return "";
        }
        char[] chars = s.toCharArray();
        int max_length = 1;
        int start = 0;
        int end = 0;

        //以奇数为中心
        for (int i = 0; i < chars.length; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right <= chars.length - 1){
                if (chars[left] == chars[right]){
                    int curr_length = right - left + 1;
                    if (curr_length > max_length){
                        max_length = curr_length;
                        start = left;
                        end = right;
                    }
                }else {
                    break;
                }
                left --;
                right ++;
            }
        }
        //以偶数为中心对称
        for (int i = 0; i < chars.length - 1 ; i++) {
            int left = i;
            int right = i + 1;
            while (left >= 0 && right <= chars.length - 1) {
                if (chars[left] == chars[right]) {
                    int curr_length = right - left + 1;
                    if (curr_length > max_length) {
                        max_length = curr_length;
                        start = left;
                        end = right;
                    }
                }else {
                    break;
                }
                left--;
                right++;
            }

        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(method("abba"));
//        System.out.println(String.valueOf(121));
    }
}
