class Solution {
    public boolean judgeCircle(String moves) {
        int vertical=0;
        int horizontal=0;
        char[] robotMoves = moves.toCharArray();
        for(char c : robotMoves){
            if(c=='U'){
                vertical+=1;
            }else if(c=='D'){
                vertical-=1;
            }else if(c=='L'){
                horizontal+=1;
            }else{
                horizontal-=1;
            }
        }
        return vertical==0 && horizontal==0;
    }
}
