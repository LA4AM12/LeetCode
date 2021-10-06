package Offer;

public class Solution04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0,j = n-1;i<m && j>=0;){
            if (matrix[i][j] < target){
                i++;
            }else if (matrix[i][j] > target){
                j--;
            }else{
                return true;
            }

        }
        return false;
    }
}
