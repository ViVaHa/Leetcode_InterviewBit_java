class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder("");
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)||(Character.isLetter(c))){
                builder.append(s.charAt(i));
            }
            
        }
        String resString=builder.toString().toLowerCase();
        int start=0;
        int end=resString.length()-1;
        while(start<end){
            if(resString.charAt(start)!=resString.charAt(end)){
                return false;
            }
            start+=1;
            end-=1;
        }
        return true;
    }
}
