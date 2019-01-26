class Solution {
    
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int index=0;
        while(index<nums.length){
            int ind=Math.abs(nums[index])-1;
            if(nums[ind]>0){
                nums[ind]=-nums[ind];
            }
            index+=1;
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                res.add(i+1);
            }
        }
        return res;
    }
}
