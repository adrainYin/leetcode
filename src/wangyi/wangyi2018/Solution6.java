package wangyi.wangyi2018;


import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/49375dd6a42d4230b0dc4ea5a2597a9b
 * 来源：牛客网
 *
 * 小易非常喜欢拥有以下性质的数列:
 * 1、数列的长度为n
 * 2、数列中的每个数都在1到k之间(包括1和k)
 * 3、对于位置相邻的两个数A和B(A在B前),都满足(A <= B)或(A mod B != 0)(满足其一即可)
 * 例如,当n = 4, k = 7
 * 那么{1,7,7,2},它的长度是4,所有数字也在1到7范围内,并且满足第三条性质,所以小易是喜欢这个数列的
 * 但是小易不喜欢{4,4,4,2}这个数列。小易给出n和k,希望你能帮他求出有多少个是他会喜欢的数列。
 *
 * 输入包括两个整数n和k(1 ≤ n ≤ 10, 1 ≤ k ≤ 10^5)
 *
 * 输入
 * 2 2
 * 输出
 * 3
 */
public class Solution6 {

    public static final int mod = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] state = new int[n + 1][k + 1];

        //定义一个无效的数组，为之后遍历提供方便
        state[0][1] = 1;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            //求得上一层的所有的和
            for (int j = 1; j <= k; j++) {
                sum = (state[i - 1][j] + sum) % mod;
            }
            //求得本层上合法的长度
            for (int j = 1; j <= k; j++) {
                int inValied = 0;
                int beishu = 2;
                while (beishu * j <= k) {
                    inValied = (inValied + state[i - 1][beishu * j]) % mod;
                    beishu ++;
                }
                //得到不合法的之后需要减去
                //这里要进行一次加mod，防止sum小于inValied而出现负数
                state[i][j] = (sum - inValied + mod) % mod;
            }
        }

        int result = 0;
        for (int i = 1; i <= k; i++) {
            result = (result + state[n][i]) % mod;
        }
        System.out.println(result);
    }
}
