package backTracing;

import java.util.HashMap;
import java.util.Map;

public class Solution494 {
    private Map<String,Integer> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums,0,target);
    }

    private int dfs(int[] nums, int cur,int target){
        if (cur == nums.length){
            if (target == 0) return 1;
            else return 0;
        }
        if (!memo.containsKey(cur + "," + target)){
            int res = dfs(nums,cur+1,target-nums[cur]) + dfs(nums,cur+1,target+nums[cur]);
            memo.put(cur + "," + target,res);
        }
        return memo.get(cur + "," + target);
    }
}
//also dp