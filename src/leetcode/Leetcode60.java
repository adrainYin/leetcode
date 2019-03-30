package leetcode;

public class Leetcode60 {
    public static String getPermutation(int n, int k) {
        boolean[] isUse = new boolean[n + 1];
        StringBuffer sb = new StringBuffer();
        if (n == 1) {
            return "1";
        }
        int tmp = k;
        int idx = n - 1;
        while (idx > 0) {
            int x = tmp / get(idx);
            int y = tmp % get(idx);
            int count = 0;
            if (y == 0) {
                for (int i = 1; i <= n; i++) {
                    if (!isUse[i]) {
                        count ++;
                    }
                    if (count == x) {
                        sb.append(i);
                        isUse[i] = true;
                        break;
                    }
                }
                for (int i = n; i >= 1; i--) {
                    if (!isUse[i]) {
                        sb.append(i);
                        isUse[i] = true;
                    }
                }
                break;
            }
            count = 0;
            for (int i = 1; i <= n; i++) {
                if (!isUse[i]) {
                    count ++;
                }
                if (count == x+1) {
                    sb.append(i);
                    isUse[i] = true;
                    break;
                }
            }
            tmp = y;
            idx --;
        }
        return sb.toString();
    }



    private static int get(int n) {
        if (n == 0) {
            return 1;
        }
        return n * get(n-1);
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4,9));

    }
}
