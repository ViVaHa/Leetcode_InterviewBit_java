class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0){
            return 0;
        }
        if(triangle.size()==1){
            int min=Integer.MAX_VALUE;
            for(int i=0;i<triangle.get(0).size();i++){
                if(triangle.get(0).get(i)<min){
                    min=triangle.get(0).get(i);
                }
            }
            return min;
        }
        for(int i=1;i<triangle.size();i++){
            List<Integer>prev=triangle.get(i-1);
            for(int j=0;j<triangle.get(i).size();j++){
                int x=Integer.MAX_VALUE;
                int z=Integer.MAX_VALUE;
                if(j>0){
                    x=prev.get(j-1);
                }
                if(j<prev.size()){
                    z=prev.get(j);
                }
                int val=Math.min(x,z)+triangle.get(i).get(j);
                triangle.get(i).set(j,val);
            }
        }
        
        int n=triangle.size()-1;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<triangle.get(n).size();i++){
            if(triangle.get(n).get(i)<min){
                min=triangle.get(n).get(i);
            }
        }
        return min;  
    }
}
