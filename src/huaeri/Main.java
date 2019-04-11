package huaeri;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");
        int num = Integer.valueOf(strs[0]);
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            if (strs[i].length() < 8) {
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < strs[i].length(); j++) {
                    sb.append(strs[i].charAt(j));
                }
                int length = strs[i].length();
                while (length < 8) {
                    sb.append(0);
                    length ++;
                }
                list.add(sb.toString());
            }
            else if (strs[i].length() == 8) {
                list.add(strs[i]);
            } else {
                int count = strs[i].length() / 8;
                int finalCount = strs[i].length() % 8;
                for (int j = 0; j < count; j++) {
                    list.add(strs[i].substring(j * 8, j * 8 + 8));
                }
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < finalCount; j++) {
                    sb.append(strs[i].charAt(count * 8 + j));
                }
                for (int j = finalCount; j < 8; j++) {
                    sb.append(0);
                }
                list.add(sb.toString());
            }
        }

        Collections.sort(list);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            sb.append(" ");
        }
        String result = sb.toString().substring(0, sb.toString().length() - 1);
        System.out.println(result);
    }
}
