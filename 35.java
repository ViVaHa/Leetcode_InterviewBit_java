class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0){
            return 0;
        }
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            if(start==end){
                if(nums[start]==target){
                    return start;
                }else if(nums[start]<target){
                    return start+1;
                }else{
                    return start;
                }
            }
            int mid=(start+end)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return start;
    }
}
