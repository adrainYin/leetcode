package leetcode;
import java.util.ArrayList;
import java.util.List;

public class Leetcode22 {

    /**
     * 用递归的思路去解决，要设计递归的返回值和终止条件。
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        doAdd(list, n, n, "");
        return list;
    }

    public static void doAdd(List<String> list, int left, int right, String str) {
        if (left == 0 && right == 0){
            list.add(str);
            return ;
        }
        if (left > 0){
            doAdd(list, left-1, right, str + "(");
        }
        if (right > 0 && right > left){
            doAdd(list, left, right - 1, str + ")");
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(4).toString());
    }
}
