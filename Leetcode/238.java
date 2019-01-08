class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod[]= new int[nums.length];
        for(int i=0;i<prod.length;i++){
            prod[i]=1;
        }
        int val=nums[0];
        for(int i=1;i<nums.length;i++){
            prod[i]*=val;
            val*=nums[i];
        }
        val=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            prod[i]*=val;
            val*=nums[i];
        }
        return prod;
    }
}
