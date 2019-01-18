class Solution {
    public boolean canBreakWord(String s, Map<String,Integer> map, int start, int end, Set<Integer> set){
        if(start>=end){
            return true;
        }
        if(set.contains(start)){
            return false;
        }
        for(int i=start;i<=end;i++){
            String substr=s.substring(start,i);
            if(map.containsKey(substr)){
                if(canBreakWord(s,map,i,end,set)){
                    return true;
                }
            }
        }
        set.add(start);
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String,Integer> hashMap = new HashMap<>(); 
        for(String str : wordDict){
            hashMap.put(str,1);
        }
        Set<Integer> set = new HashSet<>();
        return canBreakWord(s,hashMap,0,s.length(),set);
    }
}
