package offer;

/**
 * 考虑大数问题的打印n位数
 */
public class Solution17 {

    private static void printMax(int n) {
        if (n <=0 ) {
            return;
        }
        char[] num = new char[n];
        for (int i = 0; i < num.length; i++) {
            num[i] = '0';
        }

        while (!increment(num)) {
            int beginIndex = 0;
            for (int i = 0; i < num.length; i++) {
                if (num[i] != '0') {
                    beginIndex = i;
                    break;
                }
            }
            System.out.println(new String(num).substring(beginIndex));
        }
    }

    private static boolean increment(char[] number) {

        boolean isOverFlow = false;
        for (int i = number.length - 1; i >= 0; i--) {
            int tmp = number[i] - '0';
            if (i == 0 && tmp == 9) {
                isOverFlow = true;
                break;
            }
            if (tmp < 9) {
                number[i] = (char) (tmp + '1');
                break;
            } else {
                number[i] = '0';
            }
        }

        return isOverFlow;
    }

    public static void main(String[] args) {
        printMax(5);
//        System.out.println((char)(1 + '0'));
    }
}
