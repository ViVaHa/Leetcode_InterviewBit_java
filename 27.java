class Solution {
    public int removeElement(int[] nums, int val) {
        int index=0;
        int i=0;
        while(i<nums.length){
            if(nums[i]!=val){
                nums[index]=nums[i];
                index+=1;
            }
            i+=1;
        }
        return index;
    }
}
