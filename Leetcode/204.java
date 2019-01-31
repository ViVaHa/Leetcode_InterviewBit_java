class Solution {
    public int countPrimes(int n) {
        if(n<=2){
            return 0;
        }
        boolean isNotPrime[] = new boolean[n];
        isNotPrime[0]=true;
        isNotPrime[1]=true;
        isNotPrime[2]=false;
        if(n==3){
            return 1;
        }
        isNotPrime[3]=false;
        for(int i=2;i*i<n;i++){
            for(int j=i*i;j<n;j+=i){
                isNotPrime[j]=true;
            }
        }
        int cnt=0;
        for(int i=2;i<n;i++){
            if(!isNotPrime[i]){
                cnt+=1;
            }
        }
        return cnt;
    }
}
