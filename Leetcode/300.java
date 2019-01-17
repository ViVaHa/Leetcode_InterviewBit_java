class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[]= new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i]=1;
        }
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[j]>nums[i]){
                    dp[j]=Math.max(dp[j],dp[i]+1);
                }
            }
        }
        int maxVal=0;
        for(int n:dp){
            maxVal=Math.max(n,maxVal);
        }
        return maxVal;
    }
}
