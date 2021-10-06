package Offer;

import java.util.Arrays;

public class Solution60 {
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp,1.0/6);

        for (int i = 2; i <= n; i++) {
            double[] temp = new double[5*i+1];
            for (int j = 0;j < dp.length;j++){
                for (int k = 0; k < 6; k++) {
                    temp[j+k] += dp[j]/6;
                }
            }
            dp = temp;
        }

        return dp;
    }
}
