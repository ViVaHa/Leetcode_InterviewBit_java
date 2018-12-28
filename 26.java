class Solution {
    public int removeDuplicates(int[] nums) {
        int index=0;
        int i=0;
        while(i<nums.length){
            if(i>0 && nums[i]==nums[i-1]){
                i+=1;
            }
            else{
                nums[index]=nums[i];
                index+=1;
                i+=1;
            }
        }
        return index;
    }
}
