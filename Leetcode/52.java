class Solution {
    public boolean isSafe(int row, int col, List<Integer> temp){
        for(int i=0;i<temp.size();i++){
            int prevRow=i;
            int prevCol=temp.get(i);
            if(prevCol==col || Math.abs(row-prevRow)==Math.abs(col-prevCol)){
                return false;
            }
        }
        return true;
    }
    public void solve(List<Integer> temp, List<List<Integer>> places, int row, int maxRow){
        if(row==maxRow){
            places.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<maxRow;i++){
            if(isSafe(row,i,temp)){
                temp.add(i);
                solve(temp,places,row+1,maxRow);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    public int totalNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if(n==0){
            return 0;
        }
        List<List<Integer>> places = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(temp,places,0,n);
        //construct(places,res,n);
        return places.size();
    }
}
