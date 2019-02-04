class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        } 
        int[] vals = new int[(num1.length()+num2.length())-1];
        for(int i=0;i<num1.length();i++){
            for(int j=0;j<num2.length();j++){
                int val1 = Character.getNumericValue(num1.charAt(i));
                int val2 = Character.getNumericValue(num2.charAt(j));
                vals[i+j]+=val1*val2;
            }
        }
        int carry=0;
        StringBuilder builder = new StringBuilder("");
        for(int i=vals.length-1;i>=0;i--){
            int sum = carry+vals[i];
            carry=sum/10;
            builder.insert(0,String.valueOf(sum%10));
        }
        if(carry>0){
            builder.insert(0,String.valueOf(carry));
        }
        return builder.toString();
    }
}
