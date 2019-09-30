package exam58;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split("@");
        String[] MASK = {"M", "A","S", "K"};
        int index = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strs[0].length(); i++) {
            stringBuffer.append(strs[0].charAt(i));
            stringBuffer.append(MASK[index]);
            index = (index + 1) % 4;
        }

//        stringBuffer.append("@").append(strs[1]);
        System.out.println(stringBuffer.substring(0, stringBuffer.length() - 1) + "@" + strs[1]);

    }
}
