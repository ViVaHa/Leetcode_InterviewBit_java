public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int carry=1;
        for(int i=A.size()-1;i>=0;i--){
            int val=A.get(i)+carry;
            carry=val/10;
            val=val%10;
            A.set(i,val);
        }
        if(carry>0){
            ArrayList<Integer> newDigits=new ArrayList<>();
            newDigits.add(carry);
            for(int i=0;i<A.size();i++){
                newDigits.add(A.get(i));
            }
            return newDigits;
        }
        int i=0;
        while(i<A.size() && A.get(i)==0){
            A.remove(0);
        }
        return A;
    }
}

