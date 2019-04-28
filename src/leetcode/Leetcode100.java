package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode100 {



    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p == null && q != null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) & isSameTree(p.right, q.right);
    }
}
