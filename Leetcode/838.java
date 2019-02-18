class Solution {
    public String pushDominoes(String dominoes) {
        int distToLeft[] = new int[dominoes.length()];
        int distToRight[] = new int[dominoes.length()];
        for(int i=0;i<distToLeft.length;i++){
            distToLeft[i] = Integer.MAX_VALUE;
            distToRight[i] = Integer.MAX_VALUE;
        }
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        for(int i=0;i<distToRight.length;i++){
            if(dominoes.charAt(i)=='R'){
                right=i;
                distToRight[i]=0;
            }else if(dominoes.charAt(i)=='.'){
                if(right!=Integer.MAX_VALUE){
                    distToRight[i]=i-right;
                }
            }else{
                right=Integer.MAX_VALUE;
            }
            
        }
        for(int i=distToLeft.length-1;i>=0;i--){
            if(dominoes.charAt(i)=='L'){
                left=i;
                distToLeft[i]=0;
            }else if(dominoes.charAt(i)=='.'){
                if(left!=Integer.MAX_VALUE){
                    distToLeft[i]=left-i;
                }
            }
            else{
                left=Integer.MAX_VALUE;
            }
        }
        StringBuilder builder = new StringBuilder("");
        for(int i=0;i<dominoes.length();i++){
            if(distToLeft[i]==distToRight[i]){
                builder.append(".");
            }else if(distToLeft[i]<distToRight[i]){
                builder.append("L");
            }else{
                builder.append("R");
            }
        }
        return builder.toString();
    }
}
