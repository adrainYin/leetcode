package zijie;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        //String p[10];
        int[][] in = new int[12][12];
        boolean[][] flag = new boolean[12][12];
        int index = 1;
        int columns = 0;
        //经理数量
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] strs = scanner.nextLine().split(" ");
            for (int i = 0; i < strs.length; i++) {
                columns = strs.length;
                in[index][i + 1] = Integer.valueOf(strs[i]);
                if (in[index][i+1] == 1) {
                    number ++;
                }
                index ++;
            }
        }
        int rows = index - 1;
        int ifChange = 0;
        int time = 0;
        while (true) {
            ifChange = 0;
            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < columns; j++) {
                    if (in[i][j] == 1) {
                        if ((in[i-1][j] == 2 &&!flag[i - 1][j]) ||(in[i+1][j] == 2 &&!flag[i+1][j]) ||
                                (in[i][j-1] == 2 && !flag[i][j-1]) || (in[i][j+1] == 2 && !flag[i][j+1])) {
                            in[i][j] = 2;
                            flag[i][j] = true;
                            number --;
                            ifChange = 1;
                        }
                    }
                }
            }
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {
                    flag[i][j] = false;
                }
            }
            time ++;
            if (ifChange == 0 ||number == 0) {
                break;
            }
        }
        if (number == 0) {
            System.out.println(time);
        }
        else {
            System.out.println(-1);
        }

    }
}
//
//        string p[10];
//        char in[12][12];
//        bool flag[12][12];
//        int main()
//        {
//        string tmp;
//        int i = 1,j, number = 0;
//        while (getline(cin, tmp))
//        {
//        if (tmp.size() == 0)
//        break;
//        stringstream input(tmp);
//        char result;
//        j = 1;
//        while (input >> result)
//        {
//        in[i][j] = result;
//        if(result=='1')
//        number++;
//        j++;
//        }
//        i++;
//        }
//        int N = i, M = j, ifChange , time = 0;;
//        while (true)
//        {
//        ifChange = 0;
//        for (i = 1; i < N; i++)
//        {
//        for (j = 1; j < M; j++)
//        {
//        if (in[i][j] == '1')
//
//        {
//
//        if ((in[i - 1][j] == '2'&&flag[i - 1][j] == 0) || (in[i + 1][j] == '2'&&flag[i + 1][j] == 0) || (in[i][j - 1] == '2'&&flag[i][j - 1] == 0) || (in[i][j + 1] == '2'&&flag[i][j + 1] == 0))
//        {
//        in[i][j] = '2';
//        flag[i][j] = 1;
//        number--;
//        ifChange = 1;
//        }
//        }
//
//        }
//
//        }
//        for (int s = 0; s < 12; s++)
//        for (int t = 0; t < 12; t++)
//        flag[s][t] = 0;
//        time++;
//        if (!ifChange || number==0)
//        break;
//        }
//        if (number==0)
//        cout << time << endl;
//        else
//        cout << -1 << endl;
//        //system("pause");
//
//
//
//
//
//
//        return 0;
//        }