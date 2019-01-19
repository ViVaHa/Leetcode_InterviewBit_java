class Solution {
    public int maxProduct(int[] nums) {
        int maxVal=nums[0];
        int maxPosTillNow=nums[0];
        int maxNegTillNow=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int temp=maxPosTillNow;
                maxPosTillNow=Math.max(nums[i],maxNegTillNow*nums[i]);
                maxNegTillNow=Math.min(nums[i],temp*nums[i]);
            }else{
                maxPosTillNow=Math.max(nums[i],maxPosTillNow*nums[i]);
                maxNegTillNow=Math.min(nums[i],maxNegTillNow*nums[i]);
            }
            maxVal=Math.max(maxVal,maxPosTillNow);
        }
        return maxVal;
    }
}
