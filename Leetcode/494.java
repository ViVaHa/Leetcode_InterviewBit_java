class Solution {
    int totalWays;
    public int getWays(int[] nums, int sumSoFar, int index, int S, int[][]dp, int maxSum){
        if(index==nums.length){
            if(sumSoFar==S){
                return 1;
            }
            return 0;
        }
        if(dp[maxSum+sumSoFar][index]!=-1){
            return dp[maxSum+sumSoFar][index];
        }
        int one=getWays(nums,sumSoFar-nums[index],index+1,S,dp,maxSum);
        int two=getWays(nums,sumSoFar+nums[index],index+1,S,dp,maxSum);
        dp[maxSum+sumSoFar][index]=one+two;
        return dp[maxSum+sumSoFar][index];
    }
    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length==0){
            return 0;
        }
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int dp[][] = new int[(2000)][nums.length];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        totalWays=0;
        totalWays+=getWays(nums,0,0,S,dp,sum);
        return totalWays;
    }
}
