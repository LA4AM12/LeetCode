package dfs;

import Offer.struct.TreeNode;

/**
 * @author : LA4AM12
 * @create : 2022-01-25 15:13:29
 * @description : Binary Tree Cameras
 */
public class Solution968 {
    private int ans = 0;

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0)
            ans++;
        return ans;
    }

    /**
     * bottom up
     *
     * @return
     *      0 -- uncover
     *      1 -- covered
     *      2 -- camera
     */
    private int dfs(TreeNode root) {
        if (root == null)
            return -1;
        int l = dfs(root.left);
        int r = dfs(root.right);

        if (l == 0 || r == 0){
            ans++;
            return 2;
        }
        if (l == 2 || r == 2)
            return 1;

        return 0;
    }
}
