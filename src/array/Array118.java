package array;

import java.util.ArrayList;
import java.util.List;

public class Array118 {

    /**
     * 很垃圾的解法...真的是很难受了
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> trinagle = new ArrayList<>();
        if (numRows == 0){
            return trinagle;
        }
        if (numRows == 1){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            trinagle.add(list);
            return trinagle;
        }

        if (numRows == 2){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            trinagle.add(list);
            List<Integer> list2 = new ArrayList<>();
            list2.add(1);
            list2.add(1);
            trinagle.add(list2);
            return trinagle;
        }


        List<Integer> list = new ArrayList<>();
        list.add(1);
        trinagle.add(list);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        trinagle.add(list2);
        for (int i = 3; i <= numRows; i++) {
            List<Integer> curr_layer_list = new ArrayList<>();
            List<Integer> last_layer_list = trinagle.get(i - 2);
            System.out.println(last_layer_list.toString());
            curr_layer_list.add(1);
            for (int j = 0; j <= last_layer_list.size() - 2; j++){
                curr_layer_list.add(last_layer_list.get(j) + last_layer_list.get(j + 1));
            }
            curr_layer_list.add(1);
            trinagle.add(curr_layer_list);
        }
        return trinagle;
    }

    public static List<List<Integer>> method(int numRows){
        List<List<Integer>> trinagle = new ArrayList<>();

        if (numRows == 0 ){
            return trinagle;
        }

        List<Integer> first = new ArrayList<>();
        first.add(1);
        trinagle.add(first);

        for (int i = 1; i < numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            List<Integer> last = trinagle.get(i - 1);
            curr.add(1);
            for (int j = 1; j < i; j++) {
                curr.add(last.get(j - 1) + last.get(j));
            }
            curr.add(1);
            trinagle.add(curr);
        }
        return trinagle;
    }



    public static void main(String[] args) {
        System.out.println(method(4).toString());
    }
}
