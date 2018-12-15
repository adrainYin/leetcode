package leetcode;

import java.util.ArrayList;

public class Leetcode14 {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        int shortest_length = getShortestStr(strs);
        System.out.println(shortest_length);
        int i = 0;
        boolean flag = true;
        while (i < shortest_length){
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) != strs[j + 1].charAt(i)){
                    flag = false;
                    break;
                }
            }
            if (flag == false){
                break;
            }
            else {
                i ++;
            }
        }
        return strs[0].substring(0, i);
    }

    private static int getShortestStr(String[] strs) {
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            shortest = strs[i].length() < shortest ? strs[i].length() : shortest;
        }
        return shortest;
    }

    public static void main(String[] args) {
        String str1 = "a";
        String str2 = "abce";
        String str3 = "abff";
        String[] strs = {str1, str2, str3};
        System.out.println(longestCommonPrefix(strs));
    }

}