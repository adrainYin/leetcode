package offer;

/**
 * 字符串匹配. *
 */
public class Offer19 {

    public static boolean search(String str, String pattern) {
        if (str == null || str.length() == 0) {
            return true;
        }
        if ((pattern == null || pattern.length() == 0) && (str != null && str.length() != 0)) {
            return false;
        }
        return doSearch(str, pattern, 0, 0);
    }

    private static boolean doSearch(String str, String pattern, int strIndex, int patternIndex) {
        if (strIndex >= str.length() && patternIndex >= pattern.length()) {
            return true;
        }
        if (strIndex < str.length() && patternIndex >= pattern.length()) {
            return false;
        }
        if (strIndex >= str.length() && patternIndex < pattern.length()) {
            return false;
        }

        //如果第二个是*那么需要根据str的第一个字符做判断
        if (patternIndex + 1 < pattern.length() &&  pattern.charAt(patternIndex + 1) == '*') {
            if (str.charAt(strIndex) == pattern.charAt(patternIndex) || (pattern.charAt(patternIndex) == '.' && strIndex < str.length())){
                return doSearch(str, pattern, strIndex + 1, patternIndex + 2) ||
                        doSearch(str, pattern, strIndex, patternIndex + 2) ||
                        // .*的情况可以匹配任意的字符而不用移动pattern
                        doSearch(str, pattern, strIndex + 1, patternIndex);
            }
            //没有匹配上应该直接移动
            else {
                return doSearch(str, pattern, strIndex + 1, patternIndex + 1);
            }
        }

        if (str.charAt(strIndex) == pattern.charAt(patternIndex) || (pattern.charAt(patternIndex) == '.' && strIndex < str.length())) {
            return doSearch(str, pattern, strIndex + 1, patternIndex + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "b";
        String pattern = "a";
        System.out.println(search(str, pattern));
    }
}
