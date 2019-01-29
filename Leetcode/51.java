class Solution {
    public boolean isSafe(int row, int col, List<String> temp){
        for(int i=0;i<temp.size();i++){
            String str = temp.get(i);
            for(int j=0;j<temp.get(i).length();j++){
                if(str.charAt(j)=='Q'){
                    if(j==col){
                        return false;
                    }
                    if(Math.abs(row-i)==Math.abs(col-j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public void solve(List<String> temp, List<List<String>> places, int row, int maxRow, String rowValue){
        if(row==maxRow){
            places.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<maxRow;i++){
            if(isSafe(row,i,temp)){
                StringBuilder builder = new StringBuilder(rowValue);
                builder.setCharAt(i,'Q');
                temp.add(builder.toString());
                solve(temp,places,row+1,maxRow,rowValue);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if(n==0){
            return res;
        }
        List<List<String>> places = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        StringBuilder dots = new StringBuilder("");
        for(int i=0;i<n;i++){
            dots.append('.');
        }
        solve(temp,places,0,n,dots.toString());
        return places;
    }
}
