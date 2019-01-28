class Solution {
    public void generate(String s, List<String> res, StringBuilder temp, int dots, int currNum, int index){
        if(currNum>255 || dots>3){
            return;
        }
        if(index==s.length()){
            if(dots==3){
                res.add(temp.toString());
            }
            return;
        }
        if(index>s.length()){
            return;
        }
        if(currNum!=0 || ((temp.length()==0)||(temp.charAt(temp.length()-1)!='0'))){
            int num=Character.getNumericValue(s.charAt(index));
            int tempNum=currNum;
            currNum=currNum*10 + num;
            temp.append(s.charAt(index));
            generate(s,res,temp,dots,currNum,index+1);
            temp.deleteCharAt(temp.length()-1);
        }
        
        if(temp.length()>0 && (temp.charAt(temp.length()-1)!='.')){
            temp.append(".");
            currNum=0;
            generate(s,res,temp,dots+1,currNum,index);
            temp.deleteCharAt(temp.length()-1);
        }
        
    }
    public List<String> restoreIpAddresses(String s) {
        if(s.length()==0){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        StringBuilder temp = new StringBuilder("");
        generate(s,res,temp,0,0,0);
        return res;
    }
}
