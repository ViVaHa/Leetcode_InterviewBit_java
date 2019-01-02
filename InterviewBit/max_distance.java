public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        if(A.size()==1){
            return 0;
        }
        int [] left_min = new int[A.size()];
        int [] right_max = new int[A.size()];
        left_min[0]=A.get(0);
        int i,j;
        right_max[A.size()-1]=A.get(A.size()-1);
        for(i=1;i<A.size();i++){
            left_min[i]=Math.min(left_min[i-1],A.get(i));
        }
        for(j=A.size()-2;j>=0;j--){
            right_max[j]=Math.max(right_max[j+1],A.get(j));
        }
        i=0;
        j=0;
        int maxDiff=-1;
        while(i<A.size() && j<A.size()){
            if(left_min[i]<=right_max[j]){
                maxDiff=Math.max(j-i,maxDiff);
                j+=1;
            }
            else{
                i+=1;
            }
        }
        //System.out.println(i,j)
        return maxDiff;
    }
}

