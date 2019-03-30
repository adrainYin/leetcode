package leetcode;

public class Leetcode69 {
    public static int mySqrt(int x) {
        int result = 0;
        for (int i = 0; i <= x; i++) {
            int tmp = i * i;
            if (tmp == x) {
                return i;
            } else if (tmp < x) {
                result = i;
            } else {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(sqrtByBinary(10000000));
    }

    /**
     * 用牛顿迭代法 X(n + 1) = [X(n) + P / X(n)] / 2
     * @param x
     * @return
     */
    public static int getSqrt(int x) {

        if (x == 0) {
            return 0;
        }
        int initsqrt = 1;
        int curr = x;
        while (Math.abs(curr - initsqrt) > 1) {
            curr = initsqrt;
            initsqrt = (initsqrt + x / initsqrt) / 2;
        }
        return initsqrt;
    }

    private static int sqrtByBinary(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x;
        int mid = (left + right) / 2;
        long num = mid * mid;
        long numAdd = (mid + 1) * (mid + 1);
        while (!(num <= x && numAdd > x)) {
            if (num < x) {
                left = mid + 1;
                mid = (left + right) / 2;
                num = mid * mid;
                numAdd = (mid + 1) * (mid + 1);
            } else if (num > x) {
                right = mid - 1;
                mid = (left + right) / 2;
                num = mid * mid;
                numAdd = (mid + 1) * (mid + 1);
            }
        }
        return mid;

    }


}
