package offer;

public class Solution16 {

    public static void main(String[] args) {
        System.out.println(pow(-2,-2));
    }

    public static double pow(double base, int expoent) {
        if (base == 0) {
            return 0;
        }
        if (expoent == 1) {
            return base;
        }
        boolean flag = true;
        if (expoent < 0) {
            flag = false;
            expoent *= -1;
        }
        double unSignedPow = getUnSignedPow(base, expoent);
        if (flag) {
            return unSignedPow;
        }
        return 1.0 / unSignedPow;
    }

    public static double getUnSignedPow(double base, int unSignedExpoent) {
        double result = 1.0;
        for (int i = 1; i <= unSignedExpoent; i++) {
            result *= base;
        }
        return result;
    }
}
