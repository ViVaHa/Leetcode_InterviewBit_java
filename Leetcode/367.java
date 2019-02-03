class Solution {
    public boolean isPerfectSquare(int num) {
        long start=1;
        long end = num;
        if(num==1){
            return true;
        }
        while(start<=end){
            long mid = (start + end)/2;
            if(mid * mid==num){
                return true;
            }
            if(mid * mid <num){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return false;
    }
}
