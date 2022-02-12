package bfs;

import Offer.struct.TreeNode;

import java.util.*;

/**
 * @author : LA4AM12
 * @create : 2022-02-12 11:09:25
 * @description : All Nodes Distance K in Binary Tree
 */
public class Solution863 {
    // Annotate Parent
    private Map<TreeNode, TreeNode> parentMap;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList();
        Set<TreeNode> seen = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        mapParent(root, null);

        queue.add(null);  // check point
        queue.add(target);
        seen.add(null);
        seen.add(target);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (k == 0) {
                    queue.forEach(o -> ans.add(o.val));
                    break;
                }
                k--;
                queue.offer(null);  // check point
            } else {
                if (!seen.contains(node.left)) {
                    seen.add(node.left);
                    queue.offer(node.left);
                }
                if (!seen.contains(node.right)) {
                    seen.add(node.right);
                    queue.offer(node.right);
                }
                if (!seen.contains(parentMap.get(node))) {
                    seen.add(parentMap.get(node));
                    queue.offer(parentMap.get(node));
                }
            }
        }
        return ans;
    }

    private void mapParent(TreeNode cur, TreeNode parent) {
        if (cur == null) return;
        parentMap.put(cur, parent);
        mapParent(cur.left, cur);
        mapParent(cur.right, cur);
    }
}
