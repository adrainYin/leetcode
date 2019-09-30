package tree;

public class KMP {

    /**
     * next数组的求解，用的是递归的思路，一定要理解递归的过程。
     * @param nums
     * @return
     */
    public static int[] getNext(char[] nums){
        int[] next = new int[nums.length];
        next[0] = -1;
        int i = 0,k = -1;
        while (i < nums.length - 1) {
            if (k == -1 || nums[i] == nums[k]){
                next[++i] = ++k;
            }
            else {
                //递归寻找匹配的串
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abababca";
        int[] chars = getNext(str.toCharArray());
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);


        }
    }
}
