class Solution {
    public int getNumberOfDecodings(String s,int index, int dp[]){
        if(index==s.length()){
            return 1;
        }
        if(index>s.length()){
            return 0;
        }
        if(dp[index]!=Integer.MAX_VALUE){
            return dp[index];
        }
        int total=0;
        if(s.charAt(index)!='0'){
            total+=getNumberOfDecodings(s,index+1,dp);
        }
        
        if(index+1<s.length() && ((s.charAt(index)=='1') || (s.charAt(index)=='2' && s.charAt(index+1)>='0' && s.charAt(index+1)<'7'))){
            total+=getNumberOfDecodings(s,index+2,dp);
        }
        dp[index]=total;
        return total;
    }
    public int numDecodings(String s) {
        if(s.length()==0){
            return 0;
        }
        int dp[] = new int[s.length()];
        for(int i=0;i<dp.length;i++){
            dp[i] = Integer.MAX_VALUE; 
        }
        return getNumberOfDecodings(s,0,dp);
    }
}
