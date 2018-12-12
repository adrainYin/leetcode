package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums.length < 3){
            return resultList;
        }
        List<Integer> numsList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }
        Collections.sort(numsList);
        int i = 0;
        //定义一个最小的数字做判断
        int temp = numsList.get(0) - 1;
        while (i < numsList.size() - 2){
            if (temp == numsList.get(i)){
                i ++;
                continue;
            }
            temp = numsList.get(i);
            int left = i + 1;
            int right = numsList.size() - 1;
            while (left < right){
                int a = numsList.get(left);
                int b = numsList.get(right);
                if (sum(numsList.get(i), numsList.get(left), numsList.get(right)) > 0){
                    right --;
                    continue;
                }
                else if (sum(numsList.get(i), numsList.get(left), numsList.get(right)) < 0){
                    left ++;
                    continue;
                } else if(sum(numsList.get(i), numsList.get(left), numsList.get(right)) == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(numsList.get(i));
                    list.add(numsList.get(left));
                    list.add(numsList.get(right));
                    resultList.add(list);
                    left ++;
                    right --;
                }
                while (numsList.get(left) == a && left < right){
                    left ++;
                }
                while (numsList.get(right) == b && left < right){
                    right --;
                }
            }
        }
        return resultList;
    }

    private static int sum(int a, int b, int c){
        return a + b + c;
    }

    public static void main(String[] args) {
//        int[] nums = {-1, 0, 1, 2, -1, -4,-3,0,0,0};
        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(threeSum(nums));
    }
}
