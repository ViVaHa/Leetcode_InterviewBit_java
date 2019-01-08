class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> candidates = new ArrayList<>();
        int cand1=-1;
        int cand2=-1;
        int cnt1=0;
        int cnt2=0;
        for(int i=0;i<nums.length;i++){
            if(cand1==nums[i]){
                cnt1+=1;
            }else if(cand2==nums[i]){
                cnt2+=1;
            }else if(cnt1==0){
                cand1=nums[i];
                cnt1=1;
            }else if(cnt2==0){
                cand2=nums[i];
                cnt2=1;
            }
            else{
                cnt1-=1;
                cnt2-=1;
            }
            
        }
        cnt1=0;
        cnt2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==cand1){
                cnt1+=1;
            }else if(nums[i]==cand2){
                cnt2+=1;
            }
        }
        if(cnt1>(int)nums.length/3){
            candidates.add(cand1);
        }
        if(cnt2>(int)nums.length/3){
            candidates.add(cand2);
        }
        return candidates;
    }
}
