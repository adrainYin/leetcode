package offer;

public class Solution27 {

    public static void Mirror(TreeNode root) {
        if (root == null) {
            return ;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }

    private static void doMirror(TreeNode root) {

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Mirror(root);
        System.out.println(root.val);

    }
}
