class Solution {
    public void findCombinations(List<Integer>temp,List<List<Integer>>list, int k, int sum, int targetSum, int val){
        if(temp.size()>k){
            return;
        }
        if(temp.size()==k){
            if(sum==targetSum){
                List<Integer> toAddList = new ArrayList<>(temp);
                list.add(toAddList);
                return;
            }else{
                return;
            }
        }
        for(int i=val+1;i<=9;i++){
            temp.add(i);
            sum+=i;
            findCombinations(temp,list,k,sum,targetSum,i);
            sum-=i;
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>(); 
        if(n==0 && k==0){
            return list;
        }
        List<Integer> temp = new ArrayList<>();
        findCombinations(temp,list,k,0,n,0);
        return list;
    }
}
