class Solution {
    public int maxRotateFunction(int[] A) {
        if(A.length==0){
            return 0;
        }
        int sum=0;
        int totalSum=0;
        for(int i=0;i<A.length;i++){
            totalSum+= i * A[i];
            sum += A[i];
        }
        int rotations = A.length;
        int n = A.length;
        int maxSum = Integer.MIN_VALUE;
        while(rotations>0){
            rotations-=1;
            totalSum = totalSum + sum - n*A[rotations];
            maxSum = Math.max(maxSum,totalSum);
        }
        return maxSum;
    }
}
