class Solution {
    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder("");
        while(n>0){
            int rem=n%26;
            if(rem==0){
                builder.insert(0,'Z');
                n=n/26-1;
            }else{
                char val = (char) (rem + 64);
                builder.insert(0,val);
                n=n/26;
            }
            
        }
        return builder.toString();
    }
}
