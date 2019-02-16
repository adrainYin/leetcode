package offer;

import java.util.concurrent.*;

public class Solution12 {

    public static boolean findStrPath(char[][] matrix, int row, int column, String target) {
        if (matrix == null || target == null) {
            return false;
        }
        if (target.length() == 0) {
            return true;
        }

        FutureTask futureTask ;
        Executors executors;
        return true;
    }

    public String run() {

        ExecutorService executor = Executors.newScheduledThreadPool(10);
        FutureTask task = new FutureTask(new Callable<String>() {
            @Override
            public String call() throws Exception {
                String a = "hello";
                String b = "world";
                return a + b;
            }
        });
        executor.execute(task);
        executor.shutdown();
        try {
            return (String) task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        System.out.println(solution12.run());
    }
}
