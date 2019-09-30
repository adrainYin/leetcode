package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class zhizixingTree {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //奇数打印
        if (pRoot == null) {
            return result;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        //偶数打印
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(pRoot);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!stack1.isEmpty()) {
                    TreeNode treeNode = stack1.pop();
                    list.add(treeNode.val);
                    if (treeNode.left != null) {
                        stack2.push(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        stack2.push(treeNode.right);
                    }
                }
                result.add(list);
            }

            if (!stack2.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!stack2.isEmpty()) {
                    TreeNode treeNode = stack2.pop();
                    list.add(treeNode.val);
                    if (treeNode.right != null) {
                        stack1.push(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        stack1.push(treeNode.left);
                    }
                }
                result.add(list);
            }
        }
        return result;
    }
}
