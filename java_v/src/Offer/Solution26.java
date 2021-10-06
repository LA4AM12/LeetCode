package Offer;

import Offer.struct.TreeNode;

public class Solution26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return A != null && B != null && (func(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    //以A为根节点的树是否包含B
    public boolean func(TreeNode A, TreeNode B) {
        return B == null || A != null && A.val == B.val && func(A.left, B.left) && func(A.right, B.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return func2(root.left,root.right);
    }

    public boolean func2(TreeNode A, TreeNode B) {
        if (A == null && B == null)
            return true;
        if (A == null || B == null)
            return false;
        return A.val == B.val && func2(A.left, B.right) && func2(A.right, B.left);

    }

    public int[] exchange(int[] nums) {
        int l = 0, r = nums.length-1;

        while (l < r){
            while (l < r && nums[l]%2 == 1)
                l++;
            while (l<r && nums[r]%2 == 0)
                r--;
            if (l<r){
                int temp = nums[l];
                nums[l++] = nums[r];
                nums[r--] = temp;
            }
        }
        return nums;
    }
}
