package offer;

public class Offer11 {

    public static boolean VerifySquenceOfBST(int [] sequence) {

        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return dfs(0, sequence.length - 1, sequence);
    }

    private static boolean dfs(int left, int right, int[] num) {

        if (left >= right) {
            return true;
        }

        int rootVal = num[right];
        int begin = left;
        for (; begin < right; begin ++) {
            if (num[begin] > rootVal) {
                break;
            }
        }

        for (int i = begin; i < right; i++) {
            if (num[i] < rootVal) {
                return false;
            }
        }

        return dfs(left, begin - 1, num) && dfs(begin, right - 1, num);
    }

    public static void main(String[] args) {
        int[] seq = new int[]{1,3,2,8,6,5};
        System.out.println(VerifySquenceOfBST(seq));
    }
}
