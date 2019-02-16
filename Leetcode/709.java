class Solution {
    public String toLowerCase(String str) {
        StringBuilder builder = new StringBuilder("");
        for(char c : str.toCharArray()){
            if(Character.isLetter(c)){
                if(c>=97){
                    builder.append(c);
                }else{
                    builder.append((char)(c+32));
                }
            }else{
                builder.append(c);
            }
            
            
        }
        return builder.toString();
    }
}
