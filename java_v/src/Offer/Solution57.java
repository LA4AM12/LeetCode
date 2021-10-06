package Offer;

import java.util.ArrayList;
import java.util.List;

public class Solution57 {
    public int[][] findContinuousSequence(int target) {
        //模拟双指针
        int l = 1,r = 2;
        List<int[]> ans = new ArrayList<>();


        while (l < r){
            int sum = (l+r)*(r-l+1)/2;
            if (sum == target){
                int[] a = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    a[i-l] = i;
                }
                ans.add(a);
                l++;
            } else if (sum < target){
                r++;
            } else {
                l++;
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
