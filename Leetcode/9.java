class Solution {
    public boolean isPalindrome(int x) {
        if(x==0){
            return true;
        }
        int originalNum=x;
        int rev=0;
        while(x>0){
            int rem = x%10;
            rev=rev*10+rem;
            x=x/10;
        }
        return originalNum==rev;
    }
}
