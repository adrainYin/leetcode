package array;

import java.util.ArrayList;
import java.util.List;

public class Array119 {

    /**
     * 直接构造法
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> trinagle = new ArrayList<>();

        if (rowIndex == 0 ){
            List<Integer> list = new ArrayList<>();
            list.add(1);
        }

        List<Integer> first = new ArrayList<>();
        first.add(1);
        trinagle.add(first);

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> curr = new ArrayList<>();
            List<Integer> last = trinagle.get(i - 1);
            curr.add(1);
            for (int j = 1; j < i; j++) {
                curr.add(last.get(j - 1) + last.get(j));
            }
            curr.add(1);
            trinagle.add(curr);
        }
        return trinagle.get(rowIndex);
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
