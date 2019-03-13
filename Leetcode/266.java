class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s.length()==0){
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        boolean oddPresent=false;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue()%2==1){
                if(oddPresent){
                    return false;
                }
                oddPresent = true;
            }
        }
        return true;
    }
}
