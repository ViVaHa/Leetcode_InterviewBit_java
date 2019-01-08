class Solution {
    public int findMin(int[] nums) {
        if(nums.length==0){
            return -1;
        }
        if(nums.length==1){
            return nums[0];
        }
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if((mid-1<start || nums[mid-1]>nums[mid])&&(mid+1>end || nums[mid+1]>nums[mid])){
                return nums[mid];   
            }
            if(nums[start]<nums[mid] && nums[end]>nums[mid]){
                end=mid-1;
            }else{
                if(nums[mid]<nums[end]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
        }
        return -1;
    }
}
