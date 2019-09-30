package offer;

import java.util.ArrayList;
import java.util.List;

public class Offer12 {


     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }

     private ArrayList<Integer> list = new ArrayList<>();
     private ArrayList<ArrayList<Integer>> result = new ArrayList<>();


     public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if (root == null) {
            return result;
        }

        list.add(root.val);
        target = target - root.val;

        if (target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
        }
        else {
            FindPath(root.left, target);
            FindPath(root.right, target);
        }

        list.remove(list.size() - 1);
        return result;

    }

}
