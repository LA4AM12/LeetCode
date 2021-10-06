package dp;

import java.util.HashMap;
import java.util.Map;

public class Solution887 {
    //动态规划 + 二分查找
    Map<String, Integer> memo = new HashMap<>();

    public int superEggDrop(int k, int n) {
        return dp(k, n);
    }

    //两个状态 ： 对应k个鸡蛋   n个可能的楼层位置
    public int dp(int k, int n) {
        if (!memo.containsKey(k + "," + n)) {
            if (k == 1) return n;
            if (n == 0) return 0;
            int ans;
            int lo = 1, hi = n;
            while (lo + 1 < hi) {
                int x = (lo + hi) >>> 1;     //在第x层扔鸡蛋
                int t1 = dp(k - 1, x - 1);   //鸡蛋碎了   关于x的递增函数
                int t2 = dp(k, n - x);        //鸡蛋没碎   关于x的递减函数

                if (t1 < t2) {
                    lo = x;
                } else if (t1 > t2) {
                    hi = x;
                } else {
                    lo = hi = x;
                }
            }
            ans = Math.min(Math.max(dp(k - 1, lo - 1), dp(k, n - lo)), Math.max(dp(k - 1, hi - 1), dp(k, n - hi))) + 1;
            memo.put(k + "," + n, ans);
        }
        return memo.get(k + "," + n);
    }
}
