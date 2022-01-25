package greedy;

/**
 * @author : LA4AM12
 * @create : 2022-01-16 17:34:00
 * @description : Best Time to Buy and Sell Stock with Transaction Fee
 */
public class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        int profit = 0, low = prices[0];
        for (int i = 1; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            // 买！ 不亏
            if (prices[i] - low - fee > 0) {
                profit += prices[i] - low - fee;
                // 持有观望
                low = prices[i] - fee;
            }
        }
        return profit;
    }
}
