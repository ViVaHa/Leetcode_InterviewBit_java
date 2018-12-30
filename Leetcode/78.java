class Solution {
    public void generateSubsets(int[] nums, int index,List<Integer>temp, List<List<Integer>>res){
        if(index>nums.length){
            return;
        }
        if(index==nums.length){
            List<Integer> list = new ArrayList<>(temp);
            res.add(list);
            return;
        }
        generateSubsets(nums,index+1,temp,res);
        temp.add(nums[index]);
        generateSubsets(nums,index+1,temp,res);
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        if(nums.length==0){
            return res;
        }
        List<Integer>temp=new ArrayList<>();
        int index=0;
        generateSubsets(nums,index,temp,res);
        return res;
    }
}
