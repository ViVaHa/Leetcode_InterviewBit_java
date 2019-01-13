public class Solution {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> finalList = new ArrayList<>();
        if(A.size()==0){
            return finalList;
        }
        int startRow=0;
        int startCol=0;
        int endRow=A.size();
        int endCol=A.get(0).size();
        while(startCol<endCol && startRow<endRow){
            ArrayList<Integer>temp=new ArrayList<>();
            int tempCol=startCol;
            int tempRow=startRow;
            while(tempCol>=0 && tempRow<endRow){
                temp.add(A.get(tempRow).get(tempCol));
                tempRow+=1;
                tempCol-=1;
            }
            if(temp.size()>0){
                finalList.add(temp);
            }
            startCol+=1;
            if(startCol>=endCol){
                startRow+=1;
                startCol-=1;
            }
        }
        return finalList;
    }
}

