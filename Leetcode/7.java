class Solution {
    public int reverse(int x) {
        boolean isNegative=false;
        if(x<0){
            isNegative=true;
        }
        x=Math.abs(x);
        int val=0;
        while(x>0){
            if(val<0 || val>Integer.MAX_VALUE/10){
                return 0;
            }
            val=val*10+x%10;
            x=x/10;
        }
        if(isNegative){
            return -val;
        }
        return val;
    }
}
