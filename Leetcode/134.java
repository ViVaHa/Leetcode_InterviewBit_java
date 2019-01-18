class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0;
        int totalCost=0;
        int covered=0;
        int start=0;
        int end=0;
        int n=gas.length;
        while(covered<gas.length){
            totalGas+=gas[end];
            totalCost+=cost[end];
            end=(end+1)%n;
            covered+=1;
            if(totalGas<totalCost){
                while(totalGas<totalCost){
                    covered-=1;
                    totalGas-=gas[start];
                    totalCost-=cost[start];
                    start=(start+1)%n;
                    if(start==0){
                        return -1;
                    }
                }
                
            }
        }
        return start;
    }
}
