class Solution {
    public int rob(int[] nums, int start, int end) {
        if(end==start){
            return nums[start];
        }
        int[] dp = new int[end-start+1];
        dp[0] = nums[0];
        for(int i=start;i<end;i++){
            int excl = i>start? dp[i-1]:0;
            int incl = i>start+1? dp[i-2] : 0;
            dp[i] = Math.max(excl,incl+nums[i]);
        }
        return dp[end-1];
    }
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(rob(nums,0,nums.length-1),rob(nums,1,nums.length));
    }
}
