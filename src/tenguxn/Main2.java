package tenguxn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hangshu = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < hangshu; i++) {
            int nums = scanner.nextInt();
            int t = scanner.nextInt();
            for (int j = 0; j < nums; j++) {
                list.add(t);
            }
        }

        Collections.sort(list);
        int time = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) + list.get(list.size() - 1 - i) > time) {
                time = list.get(i) + list.get(list.size() - 1 - i);
            }
        }
        System.out.println(time);
    }
}
