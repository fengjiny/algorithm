package leetcode.tree;

import java.util.Stack;

public class LC_230_KthSmallestElementInABST {

    public int kthSmallest(TreeNode root, int k) {
        int count = countNode(root);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k - 1 - count);
        }
        return root.val;
    }
    public int countNode(TreeNode root) {
        if(root ==  null) return 0;
        return countNode(root.left) + countNode(root.right) + 1;
    }


    //DFS in-order recursive
    private static int number = 0;
    private static int count = 0;
    public int kthSmallest_dfs(TreeNode root, int k){
        count = k;
        dfs_helper(root);
        return number;
    }
    public void dfs_helper(TreeNode node) {
        if (node.left != null)
            dfs_helper(node.left);
        --count;
        if (count == 0) {
            number = node.val;
            return;
        }
        if (node.right != null)
            dfs_helper(node.right);
    }

    //DFS in-order iterative:
    public int kthSmallest_dfs_iter(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        while(root != null) {
            s.push(root);
            root = root.left;
        }

        while(k != 0) {
            TreeNode node = s.pop();
            --k;
            if (k == 0)
                return node.val;
            TreeNode right = node.right;
            while (right != null) {
                s.push(right);
                right = right.left;
            }
        }
        return -1;
    }
}
