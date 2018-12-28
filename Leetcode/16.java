class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest=Integer.MAX_VALUE;
        int val=-1;
        if(nums.length==0){
            return 0;
        }
        int i=0;
        Arrays.sort(nums);
        while(i<nums.length){
            int start=i+1;
            int end=nums.length-1;
            while(start<end){
                int sum=nums[i]+nums[start]+nums[end];
                //System.out.println(sum);
                if(Math.abs(sum-target)<Math.abs(closest)){
                    closest=sum-target;
                    val=sum;
                }
                if(sum==target){
                    return sum;
                }
                else if(sum<target){
                    start+=1;
                }
                else{
                    end-=1;
                }
            }
            i+=1;
        }
        return val;
    }
}
