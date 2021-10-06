package Offer;

import Offer.struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution07 {
    private int[] preorder;
    Map<Integer,Integer> index = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i],i);
        }
        return recur(0,0, inorder.length);
    }

    //返回一个子树的根节点
    //根节点preorder的下标
    //子树在inorder中的left下标和right下标
    public TreeNode recur(int root, int left, int right){
        //
        if (left >= right) return null;
        TreeNode node = new TreeNode(preorder[root]);
        int pivot = index.get(preorder[root]);
        node.left = recur(root+1,left,pivot); //左闭右开区间
        node.right = recur(pivot-left+root+1,pivot+1,right);
        return node;
    }
}
