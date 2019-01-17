class Solution {
    public void generatePermutations(List<Integer> nums, int start, int end, List<List<Integer>> res, List<Integer> temp,Map<Integer,Integer> map, int size){
        if(temp.size()==size){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<=end;i++){
            int value=nums.get(i);
            int cnt=map.get(value);
            if(cnt>0){
                temp.add(value);
                map.put(value,cnt-1);
                generatePermutations(nums,start,end,res,temp,map,size);
                temp.remove(temp.size()-1);
                map.put(value,cnt);
            }   
        }
        
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            list.add(entry.getKey());
        }
        generatePermutations(list,0,list.size()-1,res,new ArrayList<Integer>(),map,nums.length);
        return res;
    }
}
