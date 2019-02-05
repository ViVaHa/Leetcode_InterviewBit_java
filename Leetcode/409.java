class Solution {
    public int longestPalindrome(String s) {
        if(s.length()==0){
            return 0;
        }
        Map<Character,Integer> freq = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        int odd=0,count=0;
        for(Map.Entry<Character,Integer> entry : freq.entrySet()){
            if(entry.getValue()%2==1){
                odd+=1;
            }
        }
        
        if(odd==0){
            return s.length();
        }
        return s.length()-odd+1;
    }
}
