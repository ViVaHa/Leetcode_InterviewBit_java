class Solution {
    public String addBinary(String a, String b) {
        if(a==null && b==null){
            return null;
        }
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        int ind1=a.length()-1;
        int ind2=b.length()-1;
        int carry=0;
        StringBuilder builder = new StringBuilder("");
        while(ind1>=0 || ind2>=0){
            int val1=0;
            int val2=0;
            if(ind1>=0){
                val1=Character.getNumericValue(a.charAt(ind1));
            }
            if(ind2>=0){
                val2=Character.getNumericValue(b.charAt(ind2));
            }
            int sum=val1+val2+carry;
            carry=sum/2;
            sum=sum%2;
            builder.insert(0,String.valueOf(sum));
            ind1-=1;
            ind2-=1;
        }
        if(carry>0){
            builder.insert(0,String.valueOf(carry));
        }
        return builder.toString();
    }
}
