class Solution {
    public StringBuilder getHundreds(int num, Map<Integer,String>map){
        return new StringBuilder("");
    }
    public StringBuilder convert(int num, Map<Integer,String>map){
        StringBuilder builder = new StringBuilder("");
        if(num==0){
            return new StringBuilder("");
        }
        if(num>=Math.pow(10,9)){
            int new_num=num/1000000000;
           // System.out.println(String.valueOf(new_num));
            if(new_num>=10){
                builder.append(convert(new_num,map).toString());
            }else{
                builder.append(map.get(new_num));
            }
            builder.append("Billion ");
            builder.append(convert(num%1000000000,map).toString());
            return builder;
        }else if(num>=Math.pow(10,6)){
            int new_num=num/1000000;
            //System.out.println(String.valueOf(new_num));
            if(new_num>=10){
                builder.append(convert(new_num,map).toString());
            }else{
                builder.append(map.get(new_num));
            }
            builder.append("Million ");
            builder.append(convert(num%1000000,map).toString());
            return builder;
        }else if(num>=Math.pow(10,3)){
            int new_num=num/1000;
           // System.out.println(String.valueOf(new_num));
            if(new_num>=10){
                builder.append(convert(new_num,map).toString());
            }else{
                builder.append(map.get(new_num));
            }
            builder.append("Thousand ");
            builder.append(convert(num%1000,map).toString());
            return builder;
        }
        else if (num>=100){
            int new_num=(int)num/(100);
            builder.append(map.get(new_num));
            builder.append("Hundred ");
            builder.append(convert(num%100,map).toString());
            return builder;
        }else if(num>=20){
            if(num>=20 && num<30){
                builder.append(map.get(20));
            }else if(num>=30 && num<40){
                builder.append(map.get(30));
            }else if(num>=40 && num<50){
                builder.append(map.get(40));
            }else if(num>=50 && num<60){
                builder.append(map.get(50));
            }else if(num>=60 && num<70){
                builder.append(map.get(60));
            }else if(num>=70 && num<80){
                builder.append(map.get(70));
            }else if(num>=80 && num<90){
                builder.append(map.get(80));
            }else if(num>=90 && num<100){
                builder.append(map.get(90));
            }
            builder.append(convert(num%10,map).toString());
            return builder;
        }else{
            builder.append(map.get(num));
            return builder;
        }
    }
    public String numberToWords(int num) {
        Map<Integer,String> map = new HashMap<>();
        if(num==0){
            return "Zero";
        }
        map.put(1,"One ");
        map.put(2,"Two ");
        map.put(3,"Three ");
        map.put(4,"Four ");
        map.put(5,"Five ");
        map.put(6,"Six ");
        map.put(7,"Seven ");
        map.put(8,"Eight ");
        map.put(9,"Nine ");
        map.put(10,"Ten ");
        map.put(11,"Eleven ");
        map.put(12,"Twelve ");
        map.put(13,"Thirteen ");
        map.put(14,"Fourteen ");
        map.put(15,"Fifteen ");
        map.put(16,"Sixteen ");
        map.put(17,"Seventeen ");
        map.put(18,"Eighteen ");
        map.put(19,"Nineteen ");
        map.put(20,"Twenty ");
        map.put(30,"Thirty ");
        map.put(40,"Forty ");
        map.put(50,"Fifty ");
        map.put(60,"Sixty ");
        map.put(70,"Seventy ");
        map.put(80,"Eighty ");
        map.put(90,"Ninety ");
        String ret=convert(num,map).toString();
        return ret.substring(0,ret.length()-1);
    }
}
