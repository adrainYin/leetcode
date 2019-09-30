package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left  = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class Convert {


    public static List<TreeNode> list = new ArrayList<>();


    //返回的是数组
    public static void doPre(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return ;
        }

        doPre(pRootOfTree.left);
        list.add(pRootOfTree);
        doPre(pRootOfTree.right);
    }

    public static TreeNode convertt(TreeNode pRootOfTree) {

        doPre(pRootOfTree);
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i + 1);
        }
        list.get(list.size() - 1).right = null;
        for (int i = list.size() - 1; i > 0 ; i--) {
            list.get(i).left = list.get(i - 1);
        }
        list.get(0).left = null;
        return list.get(0);
    }

    public static void main(String[] args) {
        TreeNode t10 = new TreeNode(10);
        TreeNode t6 = new TreeNode(6);
        TreeNode t14 = new TreeNode(14);
        TreeNode t4 = new TreeNode(4);
        TreeNode t8 = new TreeNode(8);
        TreeNode t12= new TreeNode(12);
        TreeNode t16 = new TreeNode(16);
        t10.left = t6;
        t10.right = t14;
        t6.left = t4;
        t6.right = t8;
        t14.left = t12;
        t14.right = t16;
        t4.left = t4.right = t8.left = t8.right = t12.left = t12.right = t16.left = t16.right = null;
        System.out.println(convertt(t10));



    }
}
