class Solution {
    public int myAtoi(String str) {
        if(str.length()==0){
            return 0;
        }
        long num=0;
        int i=0;
        while(i<str.length() && str.charAt(i)==' '){
            i+=1;
        }
        if(i>=str.length()){
            return (int)num;
        }
        boolean isNegative=false;
        if(str.charAt(i)=='-'){
            isNegative=true;
            i+=1;
        }else if(str.charAt(i)=='+'){
            i+=1;
        }
        while(i<str.length()){
            if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                num=num*10+Character.getNumericValue(str.charAt(i));
                if (!isNegative && num > Integer.MAX_VALUE)
			        return Integer.MAX_VALUE;
		        if (isNegative && (-1) * num < Integer.MIN_VALUE)
			        return Integer.MIN_VALUE;
            }else{
                break;
            }
            i+=1;
        }
        if(isNegative){
            num*=-1;
        }
        if(num<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        if(num>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)num;
    }
}
