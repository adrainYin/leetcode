package zijietiaodong;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 产品经理(PM)有很多好的idea，而这些idea需要程序员实现。现在有N个PM，
 * 在某个时间会想出一个 idea，每个 idea 有提出时间、所需时间和优先等级。对于一个PM来说，
 * 最想实现的idea首先考虑优先等级高的，相同的情况下优先所需时间最小的，
 * 还相同的情况下选择最早想出的，没有 PM 会在同一时刻提出两个 idea。
 *
 * 同时有M个程序员，每个程序员空闲的时候就会查看每个PM尚未执行并且最想完成的一个idea,
 * 然后从中挑选出所需时间最小的一个idea独立实现，如果所需时间相同则选择PM序号最小的。
 * 直到完成了idea才会重复上述操作。如果有多个同时处于空闲状态的程序员，那么他们会依次进行查看idea的操作。
 *
 * 求每个idea实现的时间。
 *
 * 输入第一行三个数N、M、P，分别表示有N个PM，M个程序员，P个idea。随后有P行，每行有4个数字，分别是PM序号、提出时间、优先等级和所需时间。输出P行，分别表示每个idea实现的时间点。
 *
 * 输入描述:
 * 输入第一行三个数N、M、P，分别表示有N个PM，M个程序员，P个idea。随后有P行，每行有4个数字，分别是PM序号、提出时间、优先等级和所需时间。全部数据范围 [1, 3000]。
 * 输出描述:
 * 输出P行，分别表示每个idea实现的时间点。
 *
 * 示例1
 * 输入

 * 2 2 5
 * 1 1 1 2
 * 1 2 1 1
 * 1 3 2 2
 * 2 1 1 2
 * 2 3 5 5
 *
 * 输出

 * 3
 * 4
 * 5
 * 3
 * 9
 */

class PM {

    Queue<Task> queue = new PriorityQueue<>();
}
class Task implements Comparable<Task> {
    public int id;
    public int pmId;
    public int taskTime;
    public int privalige;
    public int needTime;

    @Override
    public int compareTo(Task o) {
        if (this.privalige != o.privalige) {
            return o.privalige - this.privalige;
        } else if (this.needTime != o.needTime) {
            return o.needTime - this.needTime;
        } else if (this.taskTime != o.taskTime) {
            return this.taskTime - o.taskTime;
        }
        return 0;
    }
}

class Programmer {
    //定义任务结束时候的时间，和队列中的任务时间做比较
    public int finishTime = 0;

}
public class Solution5 {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int P = scanner.nextInt();
        PM[] pms = new PM[N + 1];
        for (int i = 1; i <= N; i++) {
            pms[i] = new PM();
        }
        Programmer[] programmers = new Programmer[M + 1];
        for (int i = 1; i <= M; i++) {
            programmers[i] = new Programmer();
        }
        //定义结果数组，存放每一个任务的完成时间
        //编号和任务的id一一对应
        int[] result = new int[P + 1];
        //定义任务完成的数量
        int finishTaskNum = 0;
        for (int i = 1; i <= P; i++) {
            int pmId = scanner.nextInt();
            int taskTime = scanner.nextInt();
            int priority = scanner.nextInt();
            int needTime = scanner.nextInt();
            PM pm = pms[pmId];
            Task task = new Task();
            task.id = i;
            task.pmId = pmId;
            task.taskTime = taskTime;
            task.privalige = priority;
            task.needTime = needTime;
            pm.queue.offer(task);
        }

        while (finishTaskNum < P) {

        }
    }
}
