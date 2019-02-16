import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    final  String a = "ab";
    final  String b = "cd";
    public static void main(String[] args) {
        String t = "abcd";
        String s1 = "ab";
        String s2 = "cd";
        System.out.println((s1 + s2) == t);

        Integer i = 1;
        ExecutorService executorService = Executors.newCachedThreadPool();
    }
}
