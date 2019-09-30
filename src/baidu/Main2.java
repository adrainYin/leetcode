package baidu;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nums = scanner.nextInt();
        for (int i = 0; i < nums; i++) {
            int p = scanner.nextInt();
            int w = scanner.nextInt();


            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int j = 0; j < w; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if (map.get(a) == null) {
                    List<Integer> list = new ArrayList<>();
                    map.put(a, list);
                }
                //加入边
                map.get(a).add(b);
            }
            solution(p, map);


        }
    }

    public static void solution(int p, Map<Integer, List<Integer>> map) {
        
        List<Integer> fir = map.get(1);
        if (fir == null) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        for (int i = 0; i < fir.size(); i++) {
            Integer curr = fir.get(i);
            if (curr.equals(p)) {
                System.out.println("POSSIBLE");
                return ;
            }
            List<Integer> sec = map.get(curr);
            if (sec == null) {
                continue;
            }
            for (int j = 0; j < sec.size(); j++) {
                if (sec.get(j).equals(p)) {
                    System.out.println("POSSIBLE");
                    return ;
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
