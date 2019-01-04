public class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int i,j;
        for(i=0;i<a.size();i++){
            for(j=i;j<a.get(i).size();j++){
                int x=a.get(i).get(j);
                int y=a.get(j).get(i);
                a.get(i).set(j,y);
                a.get(j).set(i,x);
            }
        }
        int startCol=0;
        int endCol=a.size()-1;
        while(startCol<endCol){
            for(i=0;i<a.size();i++){
                int temp=a.get(i).get(startCol);
                a.get(i).set(startCol,a.get(i).get(endCol));
                a.get(i).set(endCol,temp);
            }
            startCol+=1;
            endCol-=1;
        }
    }
}

