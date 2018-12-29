class Solution {
    public void getAllCombinations(int[] candidates, int target, int sumSoFar, int index, List<Integer>temp, Set<List<Integer>>combinations,int maxIndex){
        if(index>=maxIndex||(index<maxIndex && sumSoFar+candidates[index]>target)){
            return;
        }
        if(sumSoFar+candidates[index]==target){
            temp.add(candidates[index]);
            List<Integer>list=new ArrayList<>(temp);
            combinations.add(list);
            temp.remove(temp.size() - 1);
            return;
        }
        getAllCombinations(candidates,target,sumSoFar,index+1,temp,combinations,maxIndex);
        sumSoFar+=candidates[index];
        temp.add(candidates[index]);
        //getAllCombinations(candidates,target,sumSoFar,index,temp,combinations);
        getAllCombinations(candidates,target,sumSoFar,index+1,temp,combinations,maxIndex);
        temp.remove(temp.size() - 1);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>>combinations=new HashSet<>();
        Arrays.sort(candidates);
        int index=candidates.length;
        List<Integer>temp=new ArrayList<>();
        getAllCombinations(candidates,target,0,0,temp,combinations,index);
        List<List<Integer>>retVal=new ArrayList<>();
        retVal.addAll(combinations);
        return retVal;
    }
}
