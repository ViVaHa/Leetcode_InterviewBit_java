/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            stack.push(i);
        }
        while(stack.size()>1){
            int c1 = stack.pop();
            int c2 = stack.pop();
            if(knows(c1,c2)){
                stack.push(c2);
            }else{
                stack.push(c1);
            }
        }
        int candidate = stack.pop();
        for(int i=0;i<n;i++){
            if(candidate!=i){
                if(knows(candidate,i) || !knows(i,candidate)){
                    return -1;
                }
            }
        }
        return candidate;
    }
}
