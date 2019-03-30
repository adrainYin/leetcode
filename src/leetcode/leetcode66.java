package leetcode;

public class leetcode66 {

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        boolean isOverFlow = true;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                isOverFlow = false;
                break;
            }
        }
        if (isOverFlow) {
            int[] newdigits = new int[length + 1];
            newdigits[0] = 1;
            for (int i = 1; i < newdigits.length; i++) {
                newdigits[i] = 0;
            }
            return newdigits;
        }

        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] ++;
                break;
            }
            digits[i] = 0;
        }
        return digits;
    }
}
