package aiiiiiiii;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static long resultNumber = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] num = new int[N];
        for (int i = 1; i < N; i++) {
            num[i] = scanner.nextInt();
        }
        int[] nums = new int[N];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i+1;
        }
//        List<List<Integer>> resultList = new ArrayList<>();
//        Main main = new Main();
//        List<List<Integer>> result = main.subPremute(nums, 0, resultList, nums);
//
//        int number = 0;
//        boolean[] isVisited = new boolean[N + 1];
//        for (int i = 0; i < result.size(); i++) {
//            List<Integer> list = result.get(i);
//            boolean sloution = true;
//            for (int j = 1; j < num.length; j++) {
//                if (num[j] == 0 && list.get(j - 1) >= list.get(j)) {
//                    sloution = false;
//                    break;
//                }
//                if (num[j] == 1 && list.get(j - 1) <= list.get(j)) {
//                    sloution = false;
//                    break;
//                }
//            }
//            if (sloution) {
//                number ++;
//            }
//        }

        System.out.println(dfs(nums, 0, nums.length, num));


        
    }


    private List<List<Integer>> subPremute(int[] nums, int premuteIndex, List<List<Integer>> resultList, boolean[] isVisited) {
        //遍历位置
        if (premuteIndex == nums.length - 1) {
            List<Integer> subList = new ArrayList<>();
            subList.add(nums[premuteIndex]);
            resultList.add(subList);
            resultNumber ++;
            return resultList;
        }
        else {
            //得到字串数组
            resultList = subPremute(nums, premuteIndex + 1, resultList, isVisited);
            List<List<Integer>> newList = new ArrayList<>();
            for (List<Integer> list : resultList) {
                for (int i = 0; i <= list.size(); i++) {
                    List<Integer> newSubList = new ArrayList<>(list);
                    newSubList.add(i, nums[premuteIndex]);
                    newList.add(newSubList);
                }
            }
            return newList;
        }
    }

    private List<List<Integer>> dfs(boolean[] nums, int index, List<List<Integer>> resultList) {
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            flag = flag && nums[i];
        }
        //遍历完
        if (index >= nums.length) {
            resultNumber ++;
            return resultList;
        }
        if (flag) {
            return resultList;
        }
        return resultList;
    }

    //给出
    private static long dfs(int[] nums, int start, int end, int[] num) {
        //排列结束
        if (start == end) {
            resultNumber ++;
            return resultNumber;
        }

        long temp = resultNumber;
        for (int i = start; i <= end; i++) {
            swap(nums, i, start);
            for (int j = start; j < num.length; j++) {
                if (num[j] == 0 && nums[j] >= nums[j + 1]) {
                    return 0;
                }
                if (num[j] == 1 && nums[j] <= nums[j + 1]) {
                    return 0;
                }
            }
            temp = (resultNumber +  dfs(nums, start + 1, end, num)) & 10000000;
            swap(nums, start, i);
        }
        return temp;
    }

    private static void swap(int[] nums, int start, int end) {
        int x = nums[start];
        nums[start] = nums[end];
        nums[end] = x;

    }


}
