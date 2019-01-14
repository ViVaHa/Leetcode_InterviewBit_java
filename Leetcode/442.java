class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer>res = new ArrayList<>();
        if(nums.length==0){
            return res;
        }
        Set<Integer>set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i])-1;
            if(nums[Math.abs(index)]<0){
                set.add(Math.abs(nums[i]));
            }else{
            	nums[Math.abs(index)]*=-1;
            }
        }
        res.addAll(set);
        return res;
    }
}
