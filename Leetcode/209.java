class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int start=0;
        int end=0;
        int sumTillNow=0;
        int minWindow=Integer.MAX_VALUE;
        while(start<nums.length && end<nums.length){
            while(end<nums.length && sumTillNow<s){
                sumTillNow+=nums[end];
                end+=1;
            }
            if(sumTillNow<s){
                break;
            }
            while(start<=end && sumTillNow>=s){
                sumTillNow-=nums[start];
                start+=1;
            }
            if(end-start+1<minWindow){
                minWindow=end-start+1;
            }
            
        }
        while(start<=end && sumTillNow>=s){
            if(end-start<minWindow){
                minWindow=end-start;
            }
            sumTillNow-=nums[start];
            start+=1;
        }
        if(minWindow==Integer.MAX_VALUE){
            return 0;
        }
        return minWindow;
    }
}
