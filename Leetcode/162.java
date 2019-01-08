class Solution {
    public int findPeakElement(int[] nums) {
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(start==end){
                return start;
            }
            if(start+1==end){
                if(nums[start]>nums[end]){
                    return start;
                }else{
                    return end;
                }
            }
            if((mid-1<start || nums[mid]>nums[mid-1])&&(mid+1>end || nums[mid]>nums[mid+1])){
                //System.out.println(mid);
                return mid;
            }
            else if(nums[mid]>nums[mid-1] && nums[mid]<nums[mid+1]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return start;
    }
}
