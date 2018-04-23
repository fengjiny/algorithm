package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LC_104_MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
    }


    public int maxDepth_BFS(TreeNode root){
        if (root == null) return 0;
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            ++res;
            int n = q.size();
            for (int i = 0; i < n; ++i) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return res;
    }
}
