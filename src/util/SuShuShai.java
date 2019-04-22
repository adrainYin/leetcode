package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 使用素数筛法得到指定范围的素数
 */
public class SuShuShai {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<Integer> list = getSuShu(num);
        System.out.println(list.toString());

    }

    private static List<Integer> getSuShu(int num) {
        boolean[] flag = new boolean[num + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            if (!flag[i]) {
                list.add(i);
                flag[i] = true;
                for (int j = 2; ; j ++) {
                    if (i * j > num) {
                        break;
                    }
                    flag[i * j] = true;
                }
            }
        }
        return list;
    }

}
