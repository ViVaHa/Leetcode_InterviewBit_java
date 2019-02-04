class Solution {
    public String intToRoman(int num) {
        String[] thousands = new String[]{"","M","MM","MMM"};
        String[] hundreds = new String[]{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] tens = new String[]{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] ones = new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX"};
        StringBuilder builder = new StringBuilder("");
        if(num>=1000){
            builder.append(thousands[num/1000]);
        }
        builder.append(hundreds[(num/100)%10]);
        builder.append(tens[(num%100)/10]);
        builder.append(ones[num%10]);
        return builder.toString();
    }
}
