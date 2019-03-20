package leetcode;

public class Leetcode29 {

    /**
     * 本题重点是用进位运算解决商的问题
     * @param dividend
     * @param divisor
     * @return
     */
    public static long divide(int dividend, int divisor) {
        if (dividend == 0){
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long long_dividend = Math.abs((long) dividend);
        long long_divisor = Math.abs((long) divisor);
        long result = 0;

        while (long_dividend >= long_divisor){
            long temp = long_divisor;
            int mi = 1;
            while (long_dividend >= (temp << 1)){
                temp <<= 1;
                mi <<= 1;
            }
            long_dividend -= temp;
            result += mi;
        }
        return (int)((sign > 0 ? result : 0 - result));
    }

    public static void sout(int a, int b){
        System.out.println(divide(a, b));
        System.out.println(a / b);
    }

    public static void main(String[] args) {
        sout(Integer.MIN_VALUE , 1);
    }
}
