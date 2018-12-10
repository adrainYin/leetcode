package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode4 {

    /**
     * 暴力求解
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> list = new ArrayList<>();

        double result = 0.0;
        if (nums1.length != 0) {
            for (int num : nums1) {
                list.add(num);
            }
        }
        if (nums2.length != 0) {
            for (int num : nums2) {
                list.add(num);
            }
        }
        Collections.sort(list);
        if (list.size() % 2 == 0){
            int a = list.get(list.size() / 2);
            int b = list.get(list.size() / 2 - 1);
            result = (double) (a + b) / 2;
        }
        else {
            result = (double)list.get(list.size() / 2);
        }
        return result;
    }

    /**
     * 使用归并排序,方法不好，因为不知道数组的顺序，是升序还是降序。
     * 待定
     * @param nums1
     * @param nums2
     * @return
     */
    public static double mergeSort(int[] nums1, int[] nums2){

        double result = 0.0;
        if (nums1.length != 0 && nums2.length != 0) {

            List<Integer> list = new ArrayList<>();
            int fir = 0;
            int sec = 0;
            while (fir != nums1.length && sec != nums2.length){
                if (nums1[fir] < nums2[sec]){
                    list.add(nums1[fir]);
                    fir ++;
                }
                else {
                    list.add(nums2[sec]);
                    sec ++;
                }
            }
            if (fir == nums1.length){
                while (sec != nums2.length){
                    list.add(nums2[sec]);
                    sec ++;
                }
            }
            else {
                while (fir != nums1.length){
                    list.add(nums1[fir]);
                    fir ++;
                }
            }

            if (list.size() %2 == 0){
                int a = list.get(list.size() / 2);
                int b = list.get(list.size() / 2 - 1);
                result = (double) (a + b) / 2;
            }
            else {
                result = (double)list.get(list.size() / 2);
            }

        }
        else if (nums2.length == 0){
            if (nums1.length % 2 == 0){
                int a = nums1[nums1.length / 2];
                int b = nums1[nums1.length / 2 - 1];
                result = (double)(a + b) / 2;
            }
            else {
                result = (double) nums1[nums1.length / 2];
            }
        }
        else {
            if (nums2.length % 2 == 0){
                int a = nums2[nums2.length / 2];
                int b = nums2[nums2.length / 2 - 1];
                result = (double)(a + b) / 2;
            }
            else {
                result = (double) nums2[nums2.length / 2];
            }
        }
        return result;

    }



    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {3,4};
        System.out.println(mergeSort(nums1, nums2));
    }
}
