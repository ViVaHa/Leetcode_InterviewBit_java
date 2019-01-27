class Solution {
    public void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start+=1;
            end-=1;
        }
    }
    public void nextPermutation(int[] nums) {
        if(nums.length==0){
            return;
        }
        int i=nums.length-1;
        while(i>0){
            if(nums[i]>nums[i-1]){
                break;
            }
            i-=1;
        }
        if(i==0){
            reverse(nums,0,nums.length-1);
            return;
        }
        i-=1;
        int max=Integer.MAX_VALUE;
        int index=-1;
        for(int j=nums.length-1;j>i;j--){
            if(nums[j]>nums[i] && nums[j]<max){
                max=nums[j];
                index=j;
            }
        }
        if(index!=-1){
            int temp=nums[i];
            nums[i]=nums[index];
            nums[index]=temp;
        }
        
        reverse(nums,i+1,nums.length-1);
    }
}
