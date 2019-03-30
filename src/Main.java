import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();
        int f = scanner.nextInt();
        boolean a1 = false;
        boolean b1 = false;
        boolean c1 = false;

        int count = 0;
        count += f;
        if (e * 11 < a) {
            count += e;
            a -= 11 * e;
        } else {
            count += e;
            a = 0;
        }
        if (5 * d < b) {
            count += d;
            b -= 5 * d;
        } else {
            count += d;
            b = 0;
        }
        count += c / 4;
        c = c % 4;
        if (c == 0) {
            if (b != 0 || a != 0)
                count++;
        } else if( c == 1) {
            count ++;
        }
        else if (c == 2) {
            if (b <= 2) {
                count++;
            } else if (b == 3) {
                if (a <= 6)
                    count++;
                else {
                    count += 2;
                }
            } else {
                count += 2;
            }
        } else {
            if (b >= 2)
                count += 2;
            else {
                if (b == 0) {
                    if (a <= 9)
                        count++;
                    else
                        count += 2;
                } else {
                    if (a > 6)
                        count += 2;
                    else
                        count++;
                }
            }

        }
        System.out.println(count);
    }

}

