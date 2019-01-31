public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        long y = n & 0x00000000ffffffffL;
        int index=0;
        int x=0;
        while(y>0){
            x=x<<1;
            if((y&1)==1){
                x = x|1;
            }
            y=y>>1;
            index+=1;
        }
        while(index<32){
            x=x<<1;
            index+=1;
        }
        return x;
    }
}
