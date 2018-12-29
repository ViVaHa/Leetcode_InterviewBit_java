class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==0){
            return true;
        }
        if(nums.length==1){
            return true;
        }
        int maxCanReachNow=nums[0];
        int maxCanReachNext=nums[0];
        for(int i=1;i<nums.length;i++){
            int j=i;
            while(j<=maxCanReachNow && j<nums.length){
                maxCanReachNext=Math.max(j+nums[j],maxCanReachNext);
                j+=1;
            }
            //System.out.println(maxCanReachNext);
            if(maxCanReachNext>=nums.length-1){
                return true;
            }
            maxCanReachNow=maxCanReachNext;
        }
        return false;
    }
}
