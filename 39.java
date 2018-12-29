class Solution {
    public void getAllCombinations(int[] candidates, int target, int sumSoFar, int index, List<Integer>temp, List<List<Integer>>combinations){
        if(index>=candidates.length||(index<candidates.length && sumSoFar+candidates[index]>target)){
            return;
        }
        if(sumSoFar+candidates[index]==target){
            temp.add(candidates[index]);
            List<Integer>list=new ArrayList<>(temp);
            combinations.add(list);
            temp.remove(temp.size() - 1);
            return;
        }
        getAllCombinations(candidates,target,sumSoFar,index+1,temp,combinations);
        sumSoFar+=candidates[index];
        temp.add(candidates[index]);
        getAllCombinations(candidates,target,sumSoFar,index,temp,combinations);
        //getAllCombinations(candidates,target,sumSoFar,index+1,temp,combinations);
        temp.remove(temp.size() - 1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>combinations=new ArrayList<>();
        if(candidates.length==0){
            return combinations;
        }
        Arrays.sort(candidates);
        List<Integer>temp=new ArrayList<>();
        getAllCombinations(candidates,target,0,0,temp,combinations);
        return combinations;
    }
}
