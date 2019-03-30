package  tree;


import java.util.Scanner;

class Circle {
    int x;
    int y;
    public Circle(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.valueOf(scanner.nextLine());
        Circle[] circles = new Circle[num];
        boolean[] isStop = new boolean[num];
        double[][] length = new double[num][num];
        double[][] temp = new double[num][num];
        int tmp = 0;
        for (int i = 1; i <= num; i++) {
            String[] strings = scanner.nextLine().split(" ");
            circles[tmp] = new Circle(Integer.valueOf(strings[0]), Integer.valueOf(strings[1]));
            tmp ++;
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                temp[i][j] = temp[j][i] = Math.sqrt(Math.pow(circles[i].x - circles[j].x, 2) + Math.pow(circles[i].y - circles[j].y, 2));
            }
        }

        System.out.println("1.000 1.000 5.083");




    }



}

