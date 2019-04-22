package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Leetcode235 {



    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null){
            return null;
        }
        else if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        else if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
            return root;
    }

    /**
     * 错误的解法，不要去尝试
     * @param args
     */
//    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null){
//            return null;
//        }
//        TreeNode minNode = p.val < q.val ? p : q;
//        TreeNode maxNode = p.val > q.val ? p : q;
//        int minNumber = minNode.val;
//        int maxNumber = maxNode.val;
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode head = root;
//        int stackSize = inOrder(head, minNumber, stack);
//
//        while (!stack.empty()){
//            TreeNode node = stack.pop();
//            if (findParent(node, maxNumber)){
//                return node;
//            }
//        }
//        return root;
//    }
//
//    private static int inOrder(TreeNode root, int val, Stack<TreeNode> stack){
//        if (root != null && root.val == val){
//            stack.push(root);
//            return stack.size();
//        }
//        else if (root != null && root.val != val) {
//            stack.push(root);
//            inOrder(root.left, val, stack);
//            inOrder(root.right, val, stack);
//        }
//        return -1;
//    }
//
//    private static boolean findParent(TreeNode root, int val){
//        if (root == null){
//            return false;
//        }
//        else if (root.val == val){
//            return true;
//        }
//        boolean left = findParent(root.left, val);
//        boolean right = findParent(root.right, val);
//        return left || right;
//    }

    public static void main(String[] args) {

        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode8  = new TreeNode(8);
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode6.left = treeNode2;
        treeNode6.right = treeNode8;
        treeNode2.left = treeNode0;
        treeNode2.right = treeNode4;
        treeNode8.left = treeNode7;
        treeNode8.right = treeNode9;
        treeNode0.left = null;
        treeNode0.right = null;
        treeNode4.left = treeNode3;
        treeNode4.right = treeNode5;
        treeNode7.left = treeNode7.right = treeNode9.left = treeNode9.right = null;
        treeNode3.left = treeNode3.right = treeNode5.left = treeNode5.right = null;

        System.out.println(lowestCommonAncestor(treeNode6, treeNode2, treeNode4).val);

    }
}
