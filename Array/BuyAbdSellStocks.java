package Array;

public class BuyAbdSellStocks {
    public int maxProfit(int[] prices) {
        int buyPrize = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i=0; i<prices.length; i++) {
            if(buyPrize<prices[i]) {
                int profit = prices[i] - buyPrize;
                maxprofit = Math.max(profit, maxprofit);
            } else {
                buyPrize = prices[i];
            }
        }
        return maxprofit;
    }
    
}
