package pinduodo0310;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        Map<Character, Integer> map = new HashMap<>(26);
        for (char c : chars) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            int count = map.get(c);
            map.put(c, count + 1);
        }

        if (map.size() == 0 || map.size() >= 3) {
            System.out.println(0);
            return;
        }
        if (map.size() == 1) {
            System.out.println(1);
            return;
        }
        System.out.println(2);

    }
}
