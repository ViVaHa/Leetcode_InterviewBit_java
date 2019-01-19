class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int start=0;
        int end=0;
        Map<Character,Integer> frequency = new HashMap<>();
        int maxLength=0;
        while(start<s.length() && end<s.length()){
            if(frequency.get(s.charAt(end))==null || frequency.get(s.charAt(end))==0){
                frequency.put(s.charAt(end),1);
                end+=1;
                if(end-start>maxLength){
                    maxLength=end-start;
                }
                
            }else{
                frequency.put(s.charAt(start),frequency.get(s.charAt(start))-1);
                start+=1;
            }
        }
        return maxLength;
    }
}
