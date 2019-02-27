class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] pair = new int[2];        
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]<0){
                pair[0] = Math.abs(nums[i]);
            }else{
                nums[Math.abs(nums[i])-1]*=-1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                pair[1] = i+1;
            }
        }
        return pair;
    }
}
