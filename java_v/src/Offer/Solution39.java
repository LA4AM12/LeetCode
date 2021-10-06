package Offer;

public class Solution39 {
    //摩尔投票法
    public int majorityElement(int[] nums) {
        int votes = 0;
        int candidate = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate)
                ++votes;
            else
                --votes;
            if (votes == 0)
                candidate =  nums[i+1];
        }

        return candidate;
    }
}
