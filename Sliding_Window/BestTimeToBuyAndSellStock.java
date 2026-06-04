public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        // int minPastPrice=prices[0];
        // int maxProfit=0;
        // for(int i=1;i<prices.length;i++)
        // {
        //     int priceToday = prices[i];
        //     int currProfit = priceToday - minPastPrice;
        //     maxProfit=Math.max(maxProfit,currProfit);
        //     minPastPrice=Math.min(minPastPrice,priceToday);
        // }
        int n = prices.length;
        //if we buy last day, we can't sell...so 
        int maxFuturePrice = prices[n-1];
        int maxProfit = 0;

        for(int i = n-2; i >= 0; i--) {
            //buy on ith day..starting from last day
            int priceToday = prices[i];
            //we get profit only if exist a future higher price
            int currProfit = maxFuturePrice - priceToday;
            maxProfit = Math.max(maxProfit, currProfit);
            //now check if ith day price is more than current sellingPrice
            maxFuturePrice = Math.max(maxFuturePrice, priceToday);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6}));    //5
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));    //0
    }
}