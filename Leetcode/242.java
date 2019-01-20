class Solution {
    public boolean isAnagram(String s, String t) {
        int s_chars[] = new int[26];
        int t_chars[] = new int[26];
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            s_chars[s.charAt(i)-'a']+=1;
            t_chars[t.charAt(i)-'a']+=1;
        }
        for(int i=0;i<26;i++){
            if(s_chars[i]!=t_chars[i]){
                return false;
            }
        }
        return true;
    }
}

