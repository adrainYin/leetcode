package zijie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.valueOf(scanner.nextLine());
        int[] nums = new int[number + 1];
        String[] strings = scanner.nextLine().split(" ");
        for (int i = 0; i < number; i++) {
            nums[i + 1] = Integer.valueOf(strings[i]);
        }
        //用hash存储长度
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 1; i < number + 1; i++) {
            if (hashMap.containsKey(nums[i])) {
                //是编号，且是有序的编号
                hashMap.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(nums[i], list);
            }
        }
        int resultNum = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < resultNum; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int k = scanner.nextInt();
            if (!hashMap.containsKey(k)) {
                System.out.println(0);
                continue;
            }
            List<Integer> list = hashMap.get(k);
            if (r < list.get(0) || l > list.get(list.size() - 1)) {
                System.out.println(0);
                continue;
            }
            int left = getIndex(list, l);
            int right = getIndex(list, r);
            System.out.println(right - left + 1);
        }
    }

    private static int getIndex(List<Integer> list, int nums) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums == list.get(mid)) {
                return mid;
            } else if (nums > list.get(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
