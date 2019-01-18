class Solution {
    public int numSquares(int n) {
        if(n==0){
            return 0;
        }
        int dp[] = new int[n+1];
        for(int i=0;i<dp.length;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0]=0;
        dp[1]=1;
        if(n==1){
            return dp[1];
        }
        dp[2]=2;
        if(n==2){
            return dp[2];
        }
        dp[3]=3;
        if(n==3){
            return dp[n];
        }
        for(int i=4;i<=n;i++){
            for(int f=1;f*f<=i;f++){
                dp[i]=Math.min(dp[i],dp[i-(f*f)]+1);
            }
            //System.out.println(dp[i]);
        }
        return dp[n];
    }
}
