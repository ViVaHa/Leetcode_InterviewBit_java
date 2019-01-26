class Solution {
    public int hammingDistance(int x, int y) {
        int num=x^y;
        int res=0;
        
        while(num>0){
            if((num&1)==1){
                res+=1;
            }
            num=num>>1;
        }
        return res;
    }
}
