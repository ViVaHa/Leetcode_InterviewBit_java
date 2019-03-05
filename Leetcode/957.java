class Solution {
    public int[] simulate(int[] cells){
        int[] res = new int[cells.length];
        for(int i=0;i<cells.length;i++){
            int sum=0;
            if(i-1>=0 && i+1<cells.length){
                sum=cells[i-1];
                sum^=cells[i+1];
                sum = 1-sum;
            }
            res[i] = sum;
        }
        return res;
    }
    public int[] prisonAfterNDays(int[] cells, int N) {
        if(N==0){
            return cells;
        }
        N = N%14;
        if(N==0){
            N=14;
        }
        int[] res = new int[cells.length];
        for(int i=0;i<N;i++){
            res = simulate(cells);
            cells = res;
        }
        return res;
    }
}
