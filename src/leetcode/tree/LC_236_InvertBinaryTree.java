package leetcode.tree;

public class LC_236_InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        final TreeNode left = root.left;
        final TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}
