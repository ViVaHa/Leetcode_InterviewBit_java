class Solution {
    public int lengthOfLastWord(String s) {
        int start=0;
        int end=0;
        int len=0;
        while(start<s.length() && end<s.length()){
            while(start<s.length() && s.charAt(start)==' '){
                start+=1;
            }
            if(start==s.length()){
                return len;
            }
            end=start;
            while(end<s.length() && s.charAt(end)!=' '){
                end+=1;
            }
            len=end-start;
            start=end;
        }
        return len;
    }
}
