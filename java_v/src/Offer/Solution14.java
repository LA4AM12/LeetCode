package Offer;

public class Solution14 {
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3;i<=n;i++){
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }

        return dp[n];
    }

    public int cuttingRope1(int n) {
        if (n <= 3) return n-1;
        int a = n / 3;
        int b = n % 3;
        if (b == 0) return (int) Math.pow(3,a);
        else if (b == 1) return (int) Math.pow(3,a-1)*4;
        else return (int) Math.pow(3,a)*2;
    }
}
