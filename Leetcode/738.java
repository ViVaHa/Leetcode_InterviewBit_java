class Solution {
    public int monotoneIncreasingDigits(int N) {
        String str = String.valueOf(N);
        int i=0;
        for(i=0;i<str.length();i++){
            if(i<str.length()-1 && str.charAt(i)>str.charAt(i+1)){
                break;
            }
        }
        if(i==str.length()){
            return N;
        }
        while(i>0 && str.charAt(i)==str.charAt(i-1)){
            i-=1;
        }
        StringBuilder builder = new StringBuilder("");
        for(int j=0;j<i;j++){
            builder.append(str.charAt(j));
        }
        builder.append(Character.getNumericValue(str.charAt(i))-1);
        for(int k=i+1;k<str.length();k++){
            builder.append("9");
        }
        return Integer.parseInt(builder.toString());
        
    }
}
