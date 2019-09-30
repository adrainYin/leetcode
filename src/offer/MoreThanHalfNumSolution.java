package offer;

public class MoreThanHalfNumSolution {

    public static int MoreThanHalfNum_Solution(int [] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int curr = array[0];
        int num = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == curr) {
                num ++;
                if (num > array.length / 2) {
                    return curr;
                }
            }
            else {
                num --;
                if (num <= 0) {
                    curr = array[i];
                    num ++;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == curr) {
                count ++;
            }
        }
        if (count > array.length / 2) {
            return curr;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,4,2,5,2,3};
        System.out.println(MoreThanHalfNum_Solution(nums));
    }
}
