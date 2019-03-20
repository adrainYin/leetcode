package  tree;
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int k = Integer.valueOf(scanner.nextInt());
//        scanner = new Scanner(System.in);
//        String[] strs = scanner.nextLine().split(" ");
//        int[] nums = new int[4];
//        for(int i = 0; i < 4; i ++) {
//            nums[i] = Integer.valueOf(strs[i]);
//        }
//        System.out.println(compute(k, nums));
//        System.out.println(computeNum(5, 3));
        int[] nuns = {1,2,3,4,5,6};


    }


    public static long compute(int k, int[] nums) {
        long result = 0;
        for(int i = 0; i <= nums[1]; i++) {
            if((k - i * nums[0]) % nums[2] != 0){
                continue;
            }
            int num_b = (k - i * nums[0]) / nums[2];
            result += computeNum(nums[1], i) * computeNum(nums[3], num_b);
        }
        return result & 1000000007;

    }

    public static long computeNum(int a, int b) {
        long result_a = 1;
        long result_b = 1;
        for(int i = b; i >= 1; i --) {
            result_a *= a - i + 1;
            result_b *= i;
        }
        return result_a / result_b;
    }
}

//class MyCompartor implements Comparator<Integer>{
//
//    @Override
//    public int compare(Integer o1, Integer o2) {
//        return o2 - o1;
//    }
//}