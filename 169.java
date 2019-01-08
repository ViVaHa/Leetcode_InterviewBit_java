class Solution {
    public int majorityElement(int[] nums) {
        int candidate=nums[0];
        int cnt=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==candidate){
                cnt+=1;
            }else{
                cnt-=1;
            }
            if(cnt==0){
                candidate=nums[i];
                cnt=1;
            }
        }
        return candidate;
    }
}
