class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        int index=0;
        int maxLen=Math.max(ransomNote.length(),magazine.length());
        while(index<maxLen){
            if(index<ransomNote.length()){
                map[ransomNote.charAt(index)-'a']-=1;
                
            }
            if(index<magazine.length()){
                map[magazine.charAt(index)-'a']+=1;
            }
            index+=1;
        }
        for(int i=0;i<26;i++){
            if(map[i]<0){
                return false;
            }
        }
        return true;
    }
}
