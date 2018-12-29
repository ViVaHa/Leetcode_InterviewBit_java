class Solution {
    static int start;
    static int end;
    public void getFirst(int[] nums, int target,int low,int high){
        if(low>high){
            return;
        }
        if(low==high){
            if(nums[low]==target){
                start=low;
            }
        }
        int mid=(high+low)/2;
        if(((mid-1>=0 && nums[mid-1]!=target)||mid-1<0)&& nums[mid]==target){
            start=mid;
            return;
        }
        if(nums[mid]>=target){
            getFirst(nums,target,low,mid-1);   
        }else{
            getFirst(nums,target,mid+1,high);
        }
    }
    public void getLast(int[] nums, int target,int low,int high){
        //System.out.print(low);
        //System.out.println(high);
        if(low>high){
            return;
        }
        if(low==high){
            if(nums[low]==target){
                end=low;
            }
        }
        int mid=(high+low)/2;
        if(((mid+1<=high && nums[mid+1]>target)||mid+1>high) && nums[mid]==target){
            end=mid;
            return;
        }
        if(nums[mid]<=target){
            getLast(nums,target,mid+1,high);   
        }else{
            getLast(nums,target,low,mid-1);
        }
    }
    
    public int[] searchRange(int[] nums, int target) {
        start=-1;
        end=-1;
        if(nums.length==0){
            return new int[]{start,end};
        }
        if(nums.length==1){
            if(nums[0]==target){
                return new int[]{0,0};
            }
            else{
                return new int[]{-1,-1};
            }
        }
        getFirst(nums,target,0,nums.length-1);
        getLast(nums,target,0,nums.length-1);
        return new int[]{start,end};
    }
}
