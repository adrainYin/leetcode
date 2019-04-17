package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode93 {

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4) {
            return result;
        }

        int length = s.length();
        dfs(result, 0, length, 1, new StringBuffer(), s);
        return result;
    }

    private static void dfs(List<String> result, int index, int length, int currNum, StringBuffer sb, String s) {
        if (currNum > 4) {
            result.add(sb.toString().substring(0, sb.toString().length() - 1));
            return;
        }
        if (currNum == 4 && length - index <= 3 && length - index >= 1) {
            int ip = Integer.valueOf(s.substring(index));
            //合法的ip
            if (ip <= 255) {
                sb.append(ip + ".");
                dfs(result, s.length(), length, currNum + 1, sb, s);
            }
        }
        //继续添加
        if (currNum < 4) {
            for (int i = 1; i < 4; i++) {
                //已经超出字符串的范围
                if (index + i > length) {
                    break;
                }
                int ip = Integer.valueOf(s.substring(index, index + i));
                if (ip <= 255) {
                    StringBuffer stringBuffer = new StringBuffer(sb);
                    stringBuffer.append(ip + ".");
                    dfs(result, index + i, length, currNum + 1, stringBuffer, s);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> result = restoreIpAddresses("255255255255");
        System.out.println(result.toString());
    }
}
