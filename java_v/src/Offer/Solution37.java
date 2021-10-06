package Offer;

import Offer.struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

//层序遍历
public class Solution37 {
    private final String SEP = ",";
    private final String NULL = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        StringBuilder builder = new StringBuilder();

        while (!deque.isEmpty()){
            TreeNode node = deque.poll();

            if (node == null){
                builder.append(NULL).append(SEP);
                continue;
            }

            builder.append(node.val).append(SEP);
            deque.offer(node.left);
            deque.offer(node.right);
        }

        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length()==0) return null;

        String[] nodes = data.split(",");
        int len = nodes.length;
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        deque.offer(root);

        for (int i = 1; i < len;) {
            TreeNode node = deque.poll();
            String left = nodes[i++];
            String right = nodes[i++];

            if (!left.equals(NULL)){
                deque.offer(node.left = new TreeNode(Integer.parseInt(left)));
            }
            if (!right.equals(NULL)){
                deque.offer(node.right = new TreeNode(Integer.parseInt(right)));
            }
        }
        return root;
    }
}
