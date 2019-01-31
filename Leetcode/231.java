class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        int cnt=0;
        while(n>0){
            if((n&1)==1){
                cnt+=1;
            }
            if(cnt>1){
                return false;
            }
            n=n>>1;
        }
        return true;
    }
}
