class Solution {
    public void sortColors(int[] nums) {
        if(nums.length==0){
            return;
        }
        int start=0;
        int end=nums.length-1;
        int mid=0;
        while(start<end && mid<=end){
            if(nums[mid]==2){
                int temp=nums[end];
                nums[end]=nums[mid];
                nums[mid]=temp;
                end-=1;
            }
            else if(nums[mid]==1){
                mid+=1;
            }
            else{
                int temp=nums[start];
                nums[start]=nums[mid];
                nums[mid]=temp;
                start+=1;
                mid+=1;
            }
        }
    }
}
