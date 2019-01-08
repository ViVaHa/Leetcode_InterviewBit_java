class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>vals=new ArrayList<>();
        List<Integer>first=new ArrayList<>();
        first.add(1);
        if(numRows==0){
            return vals;
        }
        vals.add(first);
        int i=0;
        for(i=1;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    row.add(1);
                }else{
                    row.add(vals.get(i-1).get(j-1)+vals.get(i-1).get(j));
                }
            }
            vals.add(row);
        }
        return vals;
    }
}
