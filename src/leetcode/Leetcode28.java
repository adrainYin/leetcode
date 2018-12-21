package leetcode;

public class Leetcode28 {
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0){
            return 0;
        }
        int[] next = getNext(needle.toCharArray());
        int i = 0,k = 0;
        while (i < haystack.length() && k < needle.length()){
            if (k == -1 || (haystack.charAt(i) == needle.charAt(k))){
                i++;
                k++;
            } else {
                k = next[k];
            }
        }
        if (k == needle.length()){
            return i - k;
        }
        return -1;
    }

    public static int[] getNext(char[] nums){
        int[] next = new int[nums.length];
        next[0] = -1;
        int i = 0,k = -1;
        while (i < nums.length - 1) {
            if (k == -1 || nums[i] == nums[k]){
                next[++i] = ++k;
            }
            else {
                //递归寻找匹配的串
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String haystack = "abacabababca";
        String needle = "abababca";
        System.out.println(strStr(haystack, needle));
    }
}
