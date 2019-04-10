import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");

        int num = Integer.valueOf(strs[0]);
        StringBuffer sb = new StringBuffer();
        String[] subStrs = strs[1].split("/");
        //第一个是空
        for (int i = 1; i < subStrs.length; i++) {
            sb.append("1");
        }
        sb.append(" ");
        Map<Integer, Integer> map = new HashMap<>();
        //记录子串重复的次数
        map.put(1,1);

        for (int i = 2; i < strs.length; i++) {
            boolean flag = false;
            for (int j = 1; j < i; j++) {
                //代表具有重复的路径
                if (strs[i].equals(strs[j])) {
                    //重复次数加1
                    map.put(j, map.get(j) + 1);
                    //构造答案
                    String[] tmp = strs[i].split("/");
                    sb.append("1");
                    for (int k = 2; k < tmp.length - 1; k++) {
                        sb.append(map.get(j));
                        sb.append("1");
                    }
                    sb.append("1 ");
                    //代表重复
                    flag = true;
                    break;
                }
            }
            //没有重复
            if (!flag) {
               map.put(i, 1);
               int length = strs[i].length();
                for (int j = 1; j < length; j++) {
                    sb.append("1");
                }
                sb.append(" ");
            }
        }
        String result = sb.toString().substring(0, sb.toString().length() - 1);
        System.out.println(result);

    }
}
