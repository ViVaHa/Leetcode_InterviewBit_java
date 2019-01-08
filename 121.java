class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length-1;
        int max=Integer.MIN_VALUE;
        int profit=0;
        for(int i=n;i>=0;i--){
            if(prices[i]>max){
                max=prices[i];
            }else{
                profit=Math.max(profit,max-prices[i]);
            }
        }
        return profit;
    }
}
