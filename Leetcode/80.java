class Solution {
    public int removeDuplicates(int[] nums) {
        int prev;
        int curr;
        int index=0;
        if(nums.length==0){
            return index;
        }
        prev=nums[0];
        curr=nums[0];
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            curr=nums[i];
            if(curr==prev){
                cnt+=1;
            }else{
                if(cnt>=2){
                    nums[index]=prev;
                    nums[index+1]=prev;
                    index+=2;
                }else{
                    nums[index]=prev;
                    index+=1;
                }
                cnt=1;
            }
            prev=curr;
        }
        if(cnt>=2){
            nums[index]=prev;
            nums[index+1]=prev;
            index+=2;
        }else{
            nums[index]=prev;
            index+=1;
        }
        return index;
    }
}
