package huaeri;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuffer sb = new StringBuffer();

        String result = doSolution(str);
        System.out.println(result);
    }


    private static String doSolution(String str) {
        if (str.length() == 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = str.length() - 1;
        while (i >= 0){
            //正常字符
            if (str.charAt(i) != '}' && str.charAt(i) != ']' && str.charAt(i) != ')') {
                stringBuffer.append(str.charAt(i));
                i --;
            } else if (str.charAt(i) == '}') {
                int rightIndex = i - 1;
                int nextBegin = -1;
                //寻找左边的括号匹配
                for (int j = 0; j < i; j++) {
                    //找到左括号匹配
                    if (str.charAt(j) == '{') {
                        nextBegin = j - 2;
                        int num = str.charAt(j - 1) - '0';
                        int leftIndex = j + 1;
                        for (int k = 0; k < num; k++) {
//                            sb.append(str.substring(leftIndex, rightIndex));
                            stringBuffer.append(doSolution(str.substring(leftIndex, rightIndex + 1)));
                        }
                        break;
                    }
                }
                i = nextBegin;

            } else if (str.charAt(i) == ']') {
                int rightIndex = i - 1;
                int nextBegin = -1;
                //寻找左边的括号匹配
                for (int j = 0; j < i; j++) {
                    //找到左括号匹配
                    if (str.charAt(j) == '[') {
                        nextBegin = j - 2;
                        int num = str.charAt(j - 1) - '0';
                        int leftIndex = j + 1;
                        for (int k = 0; k < num; k++) {
//                            sb.append(str.substring(leftIndex, rightIndex));
                            stringBuffer.append(doSolution(str.substring(leftIndex, rightIndex + 1)));
                        }
                        break;
                    }
                }
                i = nextBegin;
            } else if (str.charAt(i) == ')') {
                int rightIndex = i - 1;
                int nextBegin = -1;
                //寻找左边的括号匹配
                for (int j = 0; j < i; j++) {
                    //找到左括号匹配
                    if (str.charAt(j) == '(') {
                        nextBegin = j - 2;
                        int num = str.charAt(j - 1) - '0';
                        int leftIndex = j + 1;
                        for (int k = 0; k < num; k++) {
//                            sb.append(str.substring(leftIndex, rightIndex));
                            stringBuffer.append(doSolution(str.substring(leftIndex, rightIndex + 1)));
                        }
                        break;
                    }
                }
                i = nextBegin;
            }
        }
        return stringBuffer.toString();
    }
}

