class Solution {
    public String convert(String s, int numRows) {
        if(s.length()==0){
            return s;
        }
        if(numRows==1){
            return s;
        }
        int i=0;
        int index=0;
        StringBuilder[] builders = new StringBuilder[numRows];
        for(int k=0;k<numRows;k++){
            builders[k]=new StringBuilder("");
        }
        while(index<s.length()){
            while(index<s.length() && i<numRows){
                //System.out.println(cnt);
                builders[i].append(s.charAt(index));
                i+=1;
                index+=1;
            }
            i-=2;
            while(index<s.length() && i>0){
                builders[i].append(s.charAt(index));
                i-=1;
                index+=1;
            }
        }
        StringBuilder finalString = new StringBuilder("");
        for(int k=0;k<numRows;k++){
            finalString.append(builders[k].toString());
        }
        return finalString.toString();
    }
}
