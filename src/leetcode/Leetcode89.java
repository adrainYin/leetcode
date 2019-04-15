package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode89 {

    /**
     * 产生格雷编码
     * @param n G(i) = i ^ i >>1
     * 用该公式产生格雷编码
     * @return
     */
    private  static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        int num = (int)Math.pow(2, n);
        for (int i = 0; i < num; i++) {
            list.add(i ^ i >> 1);
        }

        return list;
    }


    /**
     * 使用递归的思路解决
     * @param n
     * @return
     */
    private static List<Integer> solution(int n) {
        List<Integer> list = new ArrayList<>();

        return list;
    }


    public static void main(String[] args) {
        List<Integer> list = grayCode(3);
        System.out.println(list.toString());
    }
}
