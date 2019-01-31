class Solution {
    public String countAndSay(int n) {
        StringBuilder builder = new StringBuilder("1");
        for(int i=1;i<n;i++){
            String str = builder.toString();
            builder = new StringBuilder("");
            int index=0;
            while(index<str.length()){
                int cnt=1;
                while(index+1<str.length() && str.charAt(index)==str.charAt(index+1)){
                    cnt+=1;
                    index+=1;
                }
                builder.append(str.charAt(index));
                index+=1;
            }
        }
        return builder.toString();
    }
}
