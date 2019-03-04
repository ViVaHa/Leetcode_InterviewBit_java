class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length()==0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int start=0;
        int end=0;
        int counter=0;
        int maxLength=0;
        while(end<s.length()){
            char c = s.charAt(end);
            if((!map.containsKey(c) || map.get(c)==0)){
                counter+=1; 
            }
            map.put(c,map.getOrDefault(c,0)+1);
            while(counter>k){
                char st = s.charAt(start);
                map.put(st, map.getOrDefault(st,0)-1);
                if(map.get(st)==0){
                    counter-=1;
                }
                start+=1;
            }
            if(end-start+1>maxLength){
                maxLength=end-start+1;
            }
            end+=1;
        }
        if(counter<=k && end-start-1>maxLength){
            maxLength=end-start;
        }
        return maxLength;
    }
}
