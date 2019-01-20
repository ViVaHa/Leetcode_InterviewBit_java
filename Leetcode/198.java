class Solution {
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int excluding=0;
        int including=0;
        for(int i=0;i<nums.length;i++){
            int temp=including;
            including=excluding+nums[i];
            excluding=Math.max(excluding,temp);
        }
        return Math.max(including,excluding);
    }
}
