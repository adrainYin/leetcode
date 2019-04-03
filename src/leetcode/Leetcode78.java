package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Leetcode78 {

    public static String simplifyPath(String path) {
        if (path == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        List<String> deque = new ArrayList<>();
        String[] strings = path.split("/");
        for(String str : strings) {
            //代表是合法的路径
            if (!str.equals("") && !str.equals(".") && !str.equals("..")) {
                deque.add(str);
            }
            //需要跳过
            else if (str.equals("")) {
                continue;
            }
            else if (str.equals(".")) {
                continue;
            }
            //需要返回到上一层
            else if (str.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.remove(deque.size() - 1);
                }
            }
        }
        if (!deque.isEmpty()) {
            for (int i = 0; i < deque.size(); i++) {
                sb.append("/").append(deque.get(i));
            }
        }
        else {
            sb.append("/");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home//foo/"));
    }
}
