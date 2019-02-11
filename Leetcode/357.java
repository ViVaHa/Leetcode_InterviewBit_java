class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0){
            return 1;
        }
        int sum=10;
        if(n==1){
            return sum;
        }
        sum=91;
        if(n==2){
            return sum;
        }
        int x=3;
        while(x<=n){
            int temp=9;
            for(int i=9;i>9-x+1;i--){
                temp*=i;
            }
            
            sum+=temp;
            x+=1;
        }
    return sum;
    }
}
