class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int sumSoFar=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sumSoFar=Math.max(sumSoFar+nums[i],nums[i]);
            maxSum=Math.max(maxSum,sumSoFar);
        }
        return maxSum;
    }
}
