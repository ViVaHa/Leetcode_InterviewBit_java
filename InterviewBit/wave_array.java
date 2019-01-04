public class Solution {
    public void swap(ArrayList<Integer>A, int index1, int index2){
        int temp=A.get(index1);
        A.set(index1,A.get(index2));
        A.set(index2,temp);
    }
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        int i;
        Collections.sort(A);
        for(i=0;i<A.size();i+=2){
            if(i>0 && A.get(i)<A.get(i-1)){
                swap(A,i,i-1);
            }
            if(i<A.size()-1 && A.get(i)<A.get(i+1)){
                swap(A,i,i+1);
            }
        }
        return A;
    }
}

