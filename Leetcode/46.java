class Solution {
    public void swap(int nums[], int index1, int index2){
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
    }
    public void generatePermutations(int[] nums, int start, int end, List<List<Integer>> res, List<Integer> temp){
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<=end;i++){
            if(!temp.contains(nums[i])){
                temp.add(nums[i]);
                generatePermutations(nums,start,end,res,temp);
                temp.remove(temp.size()-1);
            }   
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generatePermutations(nums,0,nums.length-1,res,new ArrayList<Integer>());
        return res;
    }
}
