//package offer;
//
//import java.util.*;
//
//public class diguiquanpailie {
//
//
//    public static ArrayList<String> resultList = new ArrayList<>();
//    public ArrayList<String> Permutation(String str) {
//
//        ArrayList<String> resultList = new ArrayList<>();
//       if (str == null || str.length() == 0) {
//           return resultList;
//       }
//
//        char[] chars = new char[str.length()];
//        for (int i = 0; i < str.length(); i++) {
//            chars[i] = str.charAt(i);
//        }
//        //先排序
//        Arrays.sort(chars);
//        boolean[] isUsed = new boolean[chars.length];
//        dfs(chars, isUsed, new ArrayList<>());
//        return resultList;
//    }
//
//    public void dfs(char[] chars, boolean[] isUsed,  List<Character> result) {
//
//        if (result.size() == chars.length) {
//            StringBuffer sb = new StringBuffer();
//            for (int i = 0; i < result.size(); i++) {
//                sb.append(result.get(i));
//            }
//            resultList.add(new String(sb));
//            return;
//        }
//
//        for (int i = 0; i < chars.length; i++) {
//            if (isUsed[i]) {
//                continue;
//            }
//            if (i > 0 && isUsed[i - 1] && chars[i] == chars[i - 1]) {
//                continue;
//            }
//            isUsed[i] = true;
//            result.add(chars[i]);
//            dfs(chars, isUsed, result);
//            result.remove(result.size() - 1);
//            isUsed[i] = false;
//        }
//
//    }
//
//    public static void main(String[] args) {
//        String str  = "a";
//        Permutation(str);
//
//        return;
//    }
//}
