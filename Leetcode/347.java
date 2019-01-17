class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums.length==0){
            return new ArrayList<>();
        }
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        List<Integer> buckets[] = new List[nums.length + 1];
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            if(buckets[entry.getValue()]==null){
                buckets[entry.getValue()]=new ArrayList<>();
                buckets[entry.getValue()].add(entry.getKey());
            }else{
                buckets[entry.getValue()].add(entry.getKey());
            }
        }
        int i=buckets.length-1;
        while(i>=0 && res.size()<k){
            if(buckets[i]!=null){
                res.addAll(buckets[i]);
            }
            i-=1;
        }
        return res;
    }
}
