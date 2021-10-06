package Offer;

import Offer.struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution34 {
    List<List<Integer>> ans = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return ans;
    }

    public void dfs(TreeNode root, int target){
        if (root == null) return;  //找准返回情况

        target -= root.val;
        path.offer(root.val);

        if (root.left == null && root.right == null && target == 0){
            ans.add(new LinkedList<>(path));
        }

        dfs(root.left,target);     //深度搜索
        dfs(root.right,target);

        path.pollLast();         //回溯
    }
}
