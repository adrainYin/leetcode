package leetcode;

public class Leetcode11 {

    public static int maxArea(int[] height) {
        int max_contain = 0;
        for (int i = 0; i < height.length; i++) {
            int left = height[i];
            for (int j = i + 1; j < height.length; j++) {
                int weight = height[j] > left ? left : height[j];
                int volume = weight * (j - i);
                max_contain = volume > max_contain ? volume : max_contain;
            }
        }
        return max_contain;
    }

    private static int method(int[] height){
        int max_volumn = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right){
            int curr_volumn = (height[left] < height[right] ? height[left] : height[right]) * (right - left);
            max_volumn = curr_volumn > max_volumn ? curr_volumn : max_volumn;
            if (height[left] > height[right]){
                right --;
            }
            else {
                left ++;
            }
        }
        return max_volumn;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(method(height));
    }
}
