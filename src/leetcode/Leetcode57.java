package leetcode;


import java.util.ArrayList;
import java.util.List;

public class Leetcode57 {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new ArrayList<>();
        int length = intervals.size();
        if (length == 0) {
            list.add(newInterval);
            return list;
        }
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = intervals.get(i).start;
        }

        int insertPos = binarySearch(nums, newInterval.start, 0, length - 1);
        //表示起始大于最大的起始
        if (insertPos >= length) {
            int end = intervals.get(length - 1).end;
            if (newInterval.start > end) {
                intervals.add(newInterval);
                return intervals;
            }
            int maxEnd = Math.max(end, newInterval.end);
            Interval newInt = new Interval(intervals.get(length - 1).start, maxEnd);
            for (int i = 0; i < length - 1; i++) {
                list.add(intervals.get(i));
            }
            list.add(newInt);
            return list;
        }

        //如果不是
        //不用考虑前面的拼接,可能拼接
        int posEnd = insertPos - 2;
        int posStart = 0;
        while (posStart <= posEnd) {
            list.add(intervals.get(posStart));
            posStart++;
        }
        if ((insertPos - 1) >= 0 ) {
            posEnd = intervals.get(insertPos - 1).end;
            if (newInterval.start > posEnd) {
                list.add(intervals.get(insertPos - 1));
                int begin = insertPos;
                int min = Math.min(intervals.get(insertPos).start, newInterval.start);
                while (begin < length) {
                    if (newInterval.end >= intervals.get(begin).start) {
                        begin ++;
                    } else {
                        break;
                    }
                }
                if (begin >= length) {
                    list.add(new Interval(min, newInterval.end));
                    return list;
                } else {
                    int max = Math.max(intervals.get(begin - 1).end, newInterval.end);
                    list.add(new Interval(min, max));
                    for (int i = begin; i < length; i++) {
                        list.add(intervals.get(i));
                    }
                    return list;
                }
            } else {
                int min = intervals.get(insertPos - 1).start;
                int begin = insertPos - 1;
                while (begin < length) {
                    if (newInterval.end >= intervals.get(begin).start) {
                        begin ++;
                    } else {
                        break;
                    }
                }
                if (begin >= length) {
                    list.add(new Interval(min, newInterval.end));
                    return list;
                } else {
                    int max = Math.max(intervals.get(begin - 1).end, newInterval.end);
                    list.add(new Interval(min, max));
                    for (int i = begin; i < length; i++) {
                        list.add(intervals.get(i));
                    }
                    return list;
                }
            }
        }
        int min = Math.min(intervals.get(0).start, newInterval.start);
        int begin = insertPos;
        while (begin < length) {
            if (newInterval.end >= intervals.get(begin).start) {
                begin ++;
            } else {
                break;
            }
        }
        if (begin >= length) {
            int max = Math.max(newInterval.end, intervals.get(length - 1).end);
            list.add(new Interval(min, max));
            return list;
        } else {
            if (begin > 0) {
                int max = Math.max(intervals.get(begin - 1).end, newInterval.end);
                list.add(new Interval(min, max));
                for (int i = begin; i < length; i++) {
                    list.add(intervals.get(i));
                }
                return list;
            } else {
                list.add(newInterval);
                for (int i = begin; i < length; i++) {
                    list.add(intervals.get(i));
                }
            }
            return list;
        }


    }


    private static int binarySearch(int[] nums, int num, int left, int right) {
        //二分法到头
        if (left >= right) {
            if (nums[left] >= num) {
                return left;
            }
            else {
                return left + 1;
            }
        }
        int mid = (left + right) / 2;
        if (nums[mid] == num) {
            return mid;
        } else if (nums[mid] > num) {
            return binarySearch(nums, num, left, mid - 1);
        } else {
            return binarySearch(nums, num, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1,5));
//        list.add(new Interval(4,5));
//        list.add(new Interval(6,7));
//        list.add(new Interval(8,10));
//        list.add(new Interval(12,16));
//        list.add(new Interval(6,9));
        Interval interval = new Interval(0,3);
        List<Interval> list1 = insert(list, interval);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i).start +"   " + list1.get(i).end);
        }
    }
}
