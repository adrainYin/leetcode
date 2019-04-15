package leetcode;


/**
 * 记录第i个柱子，以该柱子为高度的矩阵的最大面积，然后和最大值比较
 */
public class Leetcode84 {

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int max = 0;
        int left;
        int right;
        for (int i = 0; i < heights.length; i++) {
            int currHeight = heights[i];
            left = right = i;
            while (left >= 0 && heights[left] >= currHeight) {
                left --;
            }
            while (right < heights.length && heights[right] >= currHeight) {
                right++;
            }
            int curr = currHeight * (right - left -1);
            max = Math.max(max, curr);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(nums));
    }
}
