public class Solution {
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        if(A.size()==1){
            return 0;
        }
        int x_a;
        int y_a;
        int x_b;
        int y_b;
        int steps=0;
        for(int i=0;i<A.size()-1;i++){
            x_a=A.get(i);
            x_b=A.get(i+1);
            y_a=B.get(i);
            y_b=B.get(i+1);
            steps+=Math.max(Math.abs(x_b-x_a),Math.abs(y_b-y_a));
        }
        //System.out.println(steps);
        return steps;
    }
}

