package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode17 {

    /**
     * 用递归的思路解决
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
       List<String> list = new ArrayList<>();
       if (digits.length() == 0){
           return list;
       }
       String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
       return method(digits, 0, strs, list);
    }

     private static List<String> method(String digits, int index, String[] strs, List<String> list){
        int num = digits.charAt(index) - '0';
        if (index == digits.length() - 1){
            List<String> newList = new ArrayList<>();
            for (int i = 0; i < strs[num].length(); i++) {
                newList.add(strs[num].charAt(i) +"");
            }
            return newList;
        }
        List<String> subList = method(digits, index + 1, strs, list);
        List<String> newList = new ArrayList<>();
        if (strs[num].length() == 0){
            return subList;
        }
         for (int i = 0; i < strs[num].length(); i++) {
             for (String subString : subList){
                 newList.add(strs[num].charAt(i) + subString);
             }
         }
         return newList;
     }

    public static void main(String[] args) {
        String string = "2";
        System.out.println(letterCombinations(string));
        System.out.println();
    }
}
