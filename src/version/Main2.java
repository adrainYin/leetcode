package version;

        import java.text.DecimalFormat;
        import java.util.Arrays;
        import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split("<br/>");
//        for (int i = 0; i < strs.length; i++) {
//            System.out.println(strs[i]);
//        }
        for (int i = 0; i < strs.length; i++) {
            StringBuffer sb = new StringBuffer();
            String[] tmp = strs[i].split(" ");
            int[] score = new int[7];
            for (int j = 0; j < 7; j++) {
                score[j] = Integer.valueOf(tmp[j]);
            }
            Arrays.sort(score);
            double sum = 0;
            for (int j = 1; j < 6; j++) {
                sum += score[j];
            }
            double ave =  sum / 5;
            String finalScore = format(ave);
            sb.append(tmp[tmp.length - 1]).append(" ").append(finalScore).append("<br/>");
            if (i < strs.length - 1) {
                System.out.println(sb);
            } else {
                System.out.println(sb.toString().substring(0, sb.length() - 5));
            }
        }
//        System.out.println(sb.toString().substring(0, sb.length() - 5));
    }

    private static String format(double num) {

        return String.format("%.2f", num);
    }
}
