package exam360;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            int a = scanner.nextInt();
            if (!map.containsKey(a)) {
                map.put(a, 0);
            }
            map.put(a, map.get(a) + 1);
        }
        Set<Integer> set = map.keySet();
        int lanzi = 0;
        //表示每个装的数量
        for (int i = num; i >= 2; i--) {
            int count = 0;
            for (int a : set) {
                int nums = map.get(a);
                if (nums / i > 0 && nums % i == 0) {
                    count ++;
                }
                else {
                    break;
                }
            }
            //表示全部符合，那么答案就有了
            if (count == set.size()) {
                lanzi = num / i;
                break;
            }
        }
        System.out.println(lanzi);

    }
}
