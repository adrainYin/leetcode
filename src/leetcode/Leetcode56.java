package leetcode;


import java.util.*;

class Interval {
    int start;
      int end;
     Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }


  class MyCompator implements Comparator<Interval> {

      @Override
      public int compare(Interval o1, Interval o2) {
          return o1.start - o2.start;
      }
  }


public class Leetcode56 {



    public static List<Interval> merge(List<Interval> intervals) {

        List<Interval> list = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) {
            return list;
        }

        Collections.sort(intervals, new MyCompator());
        int i = 0,j = 1;
        while (i <= intervals.size() - 1) {
            int temp = i;
            int maxStart = intervals.get(i).start;
            int maxEnd = intervals.get(i).end;
            while (j <= intervals.size() - 1 && maxEnd >= intervals.get(j).start) {
                maxStart = maxStart < intervals.get(j).start ? intervals.get(j).start : maxStart;
                maxEnd = maxEnd < intervals.get(j).end ? intervals.get(j).end : maxEnd;
                temp++;
                j++;
            }
            if (j <= intervals.size() - 1) {
                Interval interval = new Interval(intervals.get(i).start, maxEnd);
                list.add(interval);
                i = j;
                j++;
            } else {
                Interval interval = new Interval(intervals.get(i).start, maxEnd);
                list.add(interval);
                i = j;
            }

        }
        return list;
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(2,3));
        list.add(new Interval(5,5));
        list.add(new Interval(2,2));
        list.add(new Interval(3,4));
        list.add(new Interval(3,4));

        List<Interval> intervalList = merge(list);
        for (int i = 0; i < intervalList.size(); i++) {
            System.out.println(intervalList.get(i).start + "  " +intervalList.get(i).end);
        }
    }
}
