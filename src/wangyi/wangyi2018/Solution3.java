package wangyi.wangyi2018;


import java.util.Scanner;

/**
 * 小易为了向他的父母表现他已经长大独立了,他决定搬出去自己居住一段时间。
 * 一个人生活增加了许多花费: 小易每天必须吃一个水果并且需要每天支付x元的房屋租金。
 * 当前小易手中已经有f个水果和d元钱,小易也能去商店购买一些水果,商店每个水果售卖p元。
 * 小易为了表现他独立生活的能力,希望能独立生活的时间越长越好,小易希望你来帮他计算一下他最多能独立生活多少天。
 *
 * 输入包括一行,四个整数x, f, d, p(1 ≤ x,f,d,p ≤ 2 * 10^9),以空格分割
 *
 * 3 5 100 10
 */
public class Solution3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int f = scanner.nextInt();
        int d = scanner.nextInt();
        int p = scanner.nextInt();

        if (d / x <= f) {
            System.out.println(d / x);
            return;
        }
        int m = d - f * x;
        System.out.println(m / (x + p) + f);
    }
}
