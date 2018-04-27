package interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TreeTravel {

    /**
     * 多叉树的遍历
     */
    public static void travel(MultiTree root) {
        if (root == null) return;
        Queue<MultiTree> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            for (int i = 0; i < n; ++i) {
                MultiTree node = q.poll();
                System.out.print(node.val + " ");
                if (node.childs != null) {
                    for (MultiTree child : node.childs) {
                        q.offer(child);
                    }
                }
            }
            System.out.println();
        }
    }

    public static void setChilds(MultiTree root, int[] nums) {
        List<MultiTree> subList = new ArrayList<>();
        for (int i : nums) {
            subList.add(new MultiTree(i));
        }
        root.childs = subList;
    }




    public static void main(String[] args) {
        MultiTree root = new MultiTree(1);


        int[] level1= {3,2,5,6,2,9};
        setChilds(root, level1);
        travel(root);

    }
}


