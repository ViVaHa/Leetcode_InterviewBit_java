class Solution {
    public int numJewelsInStones(String J, String S) {
        if(S.length()==0){
            return 0;
        }
        Map<Character,Integer> stonesCount = new HashMap<>();
        char[] arr = S.toCharArray();
        for(char c:arr){
            stonesCount.put(c,stonesCount.getOrDefault(c,0)+1);
        }
        int res=0;
        char jewels[] = J.toCharArray();
        for(char jewel:jewels){
            if(stonesCount.get(jewel)!=null){
                res+=stonesCount.get(jewel);
            }
        }
        return res;
    }
}
