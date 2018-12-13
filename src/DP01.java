import java.util.ArrayList;
import java.util.List;

public class DP01 {

    public static int getMaxValueUseDP(int[] w, int v[], int capacity){

        int[][] object = new int[w.length + 1][capacity + 1];

        for (int i = 0; i <= w.length; i++) {
            object[i][capacity] = 0;
        }
        for (int i = 0; i <= capacity; i++) {
            object[0][i] = 0;
        }
        for (int i = 1; i <= w.length; i++) {

            for (int j = 1; j <= capacity; j++) {
                //此时放不下
                if (w[i-1] > j){
                    object[i][j] = object[i - 1][j];
                }
                else {
                    if (object[i - 1][j] > object[i-1][j - w[i-1]] + v[i-1]){
                        object[i][j] = object[i -1][j];
                    }
                    else {
                        object[i][j] = object[i -1][j - w[i-1]] + v[i-1];
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        int i = w.length;
        int j = capacity;
        while (i > 0){
            if (object[i-1][j] == object[i][j]){
                i --;
            }
            else {
                list.add(i - 1);
                j = j - w[i -1];
                i --;
            }
        }
        System.out.println(list.toString());

        return object[w.length][capacity];
    }


    public static void main(String[] args) {
        int[] w = {2,3,4,5};
        int[] v = {3,4,5,6};
        System.out.println(getMaxValueUseDP(w, v, 8));
    }
}
