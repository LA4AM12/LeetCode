package greedy;

/**
 * @author : LA4AM12
 * @create : 2022-01-16 17:34:00
 * @description : Best Time to Buy and Sell Stock II
 */
public class Solution122 {
    // go on crawling over the slope
    // and keep on adding the profit
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
