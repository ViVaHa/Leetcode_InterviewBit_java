class Solution {
    public int findPairs(int[] nums, int k) {
        if(k<0){
            return 0;
        }
        if(nums.length==0){
            return 0;
        }
        Map<Integer, Long> map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0l)+1);
        }
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(k==0){
                if(map.get(nums[i]-k)!=null && map.get(nums[i]-k)>1){
                    cnt+=1;
                    map.put(nums[i]-k,0l);
                }
            }
            else if(map.get(nums[i]-k)!=null && map.get(nums[i]-k)!=0l){
                map.put(nums[i]-k,0l);
                cnt+=1;
            }
        }
        return cnt;
    }
}
