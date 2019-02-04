public class Solution {
    public void reverse(StringBuilder builder, int start, int end){
        while(start<end){
            char temp = builder.charAt(start);
            builder.setCharAt(start,builder.charAt(end));
            builder.setCharAt(end,temp);
            start+=1;
            end-=1;
        }
    }
    public String reverseWords(String s) {
        s=s.trim();
        StringBuilder builder = new StringBuilder(s);
        reverse(builder,0,builder.length()-1);
        int start=0;
        int end=0;
        while(end<s.length() && builder.charAt(end)==' '){
            builder.deleteCharAt(end);
        }
        start=end;
        while(end<builder.length()){
            while(end<builder.length() && builder.charAt(end)!=' '){
                end+=1;
            }
            reverse(builder,start,end-1);
            start=end+1;
            while(start<builder.length() && builder.charAt(start)==' '){
                builder.deleteCharAt(start);
            }
            end=start;
        }
        return builder.toString();
        
    }
}
