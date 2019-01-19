class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder("");
        if(strs.length==0){
            return "";
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            if(strs[i].length()<min){
                min=strs[i].length();
            }
        }
        for(int i=0;i<min;i++){
            char val=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)!=val){
                    return builder.toString();
                }
                //System.out.println(strs[j].charAt(i));
            }
            builder.append(val);
        }
        return builder.toString();
    }
}
