class Solution {
    public String customSortString(String S, String T) {
        if(S.length()==0){
            return "";
        }
        int freq[] = new int[26];
        for(int i=0;i<T.length();i++){
            freq[T.charAt(i)-'a']+=1;
        }
        StringBuilder builder = new StringBuilder("");
        for(char c : S.toCharArray()){
            while(freq[c-'a']>0){
                builder.append(c);
                freq[c-'a']-=1;
            }
        }
        for(int i=0;i<freq.length;i++){
            while(freq[i]>0){
                builder.append((char) (i+97));
                freq[i]-=1;
            }
        }
        return builder.toString();
        
    }
}
