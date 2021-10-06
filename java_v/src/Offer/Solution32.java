package Offer;

import Offer.struct.TreeNode;

import java.util.*;

public class Solution32 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> l = new ArrayList<>();

        boolean reverse = false;
        if (root != null){
            q.add(root);
        }
        while (!q.isEmpty()) {
            LinkedList<Integer> l0 = new LinkedList<>();
            for (int i = q.size();i>0;i--){
                TreeNode node = q.poll();

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                if (reverse) {
                    l0.addFirst(node.val);
                }else {
                    l0.add(node.val);
                }
            }
            reverse = !reverse;
            l.add(l0);
        }
        return l;
    }
}

