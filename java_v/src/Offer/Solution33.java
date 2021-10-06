package Offer;

public class Solution33 {
    private int[] postorder;
    public boolean verifyPostorder(int[] postorder) {
        this.postorder = postorder;
        return verify(0,postorder.length-1);
    }

    public boolean verify(int left , int right){
        if (left >= right) return true;
        int root = postorder[right];
        int p1 = left, p2 = right-1;

        while (postorder[p1] < root) p1++;
        while (p2 > 0 && postorder[p2] > root) p2--;

        if (p2 > p1) return false;

        return verify(left,p2) && verify(p1,right-1);
    }
}
