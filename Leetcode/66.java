class Solution {
    public int[] plusOne(int[] digits) {
        int carry=1;
        for(int i=digits.length-1;i>=0;i--){
            int val=digits[i]+carry;
            carry=val/10;
            val=val%10;
            digits[i]=val;
        }
        if(carry>0){
            int newDigits[]=new int[digits.length+1];
            newDigits[0]=carry;
            for(int i=0;i<digits.length;i++){
                newDigits[i+1]=digits[i];
            }
            return newDigits;
        }
        return digits;
    }
}
