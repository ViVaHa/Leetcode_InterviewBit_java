class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        int sCount[] = new int[256];
        int tCount[] = new int[256];
        for(int i=0;i<s.length();i++){
            sCount[(int)s.charAt(i)]+=1;
            tCount[(int)t.charAt(i)]+=1;
            if(map.get(s.charAt(i))==null){
                map.put(s.charAt(i),t.charAt(i));
            }else{
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }
            if(sCount[(int)s.charAt(i)]!=tCount[(int)t.charAt(i)]){
                    return false;
            }
            
            
        }
        
        return true;
    }
}
