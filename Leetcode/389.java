class Solution {
    public char findTheDifference(String s, String t) {
        int[] map = new int[26];
        int index=0;
        int maxLen=Math.max(s.length(),t.length());
        while(index<maxLen){
            if(index<s.length()){
                map[s.charAt(index)-'a']-=1;
                
            }
            if(index<t.length()){
                map[t.charAt(index)-'a']+=1;
            }
            index+=1;
        }
        for(int i=0;i<26;i++){
            if(map[i]>0){
                return (char)(i+97);
            }
        }
        return ' ';
    }
}
