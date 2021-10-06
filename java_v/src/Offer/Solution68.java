package Offer;


import Offer.struct.TreeNode;

public class Solution68 {
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);

        if (max < root.val)
            return lowestCommonAncestor1(root.left, p, q);
        else if (min > root.val)
            return lowestCommonAncestor1(root.right, p, q);

        return root;
    }

    TreeNode ans = null;
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }


    //判断以root为根节点的树是否包含p或者q
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        //判断左（右）子树是否包含
        boolean l = dfs(root.left, p, q);
        boolean r = dfs(root.right, p, q);

        //一个在左边一个在右边
        //或者root为其中一个 并且 root为根的节点包含另一个
        if (l&&r || ((l||r)&&(root.val == p.val || root.val == q.val))){
            ans = root;
        }

        return root.val == p.val || root.val == q.val || l || r;
    }
}
