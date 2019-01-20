class Solution {
    public int[] computeLPS(String needle){
        int[] lps = new int[needle.length()];
        int i=1,j=0;
        int len=0;
        while(i<needle.length()){
            if(needle.charAt(i)==needle.charAt(j)){
                lps[i]=j+1;
                i+=1;
                j+=1;
                len+=1;
            }else{
                if(len!=0){
                    j=lps[j-1];
                    len=0;
                }else{
                    lps[i]=0;
                    i+=1;
                }
            }
        }
        return lps;
    }
    public int strStr(String haystack, String needle) {
        if(needle.length()==0 && haystack.length()==0){
            return 0;
        }
        if(needle.length()==0){
            return 0;
        }else if(haystack.length()==0){
            return -1;
        }
        int [] lps = computeLPS(needle);
        int i=0;
        int j=0;
        int len=0;
        
        while(i<haystack.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i+=1;
                j+=1;
                if(j==needle.length()){
                    return i-j;
                }
            }else{
                if(j!=0){
                    j=lps[j-1];
                }else{
                    i+=1;
                }
            }
        }
        return -1;
    }
}
