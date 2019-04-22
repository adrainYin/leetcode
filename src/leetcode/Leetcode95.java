package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode95 {

    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }

        return subTree(1, n);
    }

    private static List<TreeNode> subTree(int left, int right) {
        //这里可能会有空指针，所以要返回空的
        if (left > right) {
            return new ArrayList<>();
        }
        List<TreeNode> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {

            List<TreeNode> leftList = subTree(left, i - 1);
            List<TreeNode> rightList = subTree(i + 1, right);
            List<TreeNode> parentList = new ArrayList<>();
            //表示是叶子结点
            if (leftList.size() == 0 && rightList.size() == 0) {
                TreeNode cur = new TreeNode(i);
                cur.left = null;
                cur.right = null;
                parentList.add(cur);
            }
            else if (leftList.size() == 0) {
                for (TreeNode node : rightList) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = null;
                    cur.right = node;
                    parentList.add(cur);
                }
            }
            else if (rightList.size() == 0) {
                for (TreeNode node : leftList) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = node;
                    curr.right = null;
                    parentList.add(curr);
                }
            }
            else {
                for(TreeNode leftNode : leftList) {
                    for (TreeNode rightNode : rightList) {
                        TreeNode curr = new TreeNode(i);
                        curr.left = leftNode;
                        curr.right = rightNode;
                        parentList.add(curr);
                    }
                }
            }
            result.addAll(parentList);
        }
        return result;
    }

    public static void main(String[] args) {
        List<TreeNode> result = generateTrees(3);
        System.out.println(result.size());
        for (TreeNode node : result) {
            while (node != null) {
                System.out.println(node.val);
            }
        }
    }
}
