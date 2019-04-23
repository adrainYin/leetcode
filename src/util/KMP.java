package util;

public class KMP {


    public static int[] getNext(String str) {
        char[] p = str.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                if (p[++j] == p[++k]) { // 当两个字符相等时要跳过
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abac";
        int[] next = getNext(str);
        for(int num : next) {
            System.out.println(num);
        }
    }
}
