public class Solution {
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {
        if(a.size()==0){
            return -1;
        }
        int candidateA=Integer.MIN_VALUE;
        int candidateB=Integer.MIN_VALUE;
        int countA=0;
        int countB=0;
        for(int i=0;i<a.size();i++){
            int ele=a.get(i);
            if(ele==candidateA){
                countA+=1;
            }else if(ele==candidateB){
                countB+=1;
            }else if(countA==0){
                candidateA=ele;
                countA=1;
            }else if(countB==0){
                candidateB=ele;
                countB=1;
            }else{
                countA-=1;
                countB-=1;
            }
        }
        int n=(int)a.size()/3;
        countA=0;
        countB=0;
        for(int i=0;i<a.size();i++){
            int ele=a.get(i);
            if(ele==candidateA){
                countA+=1;
            }else if (ele==candidateB){
                countB+=1;
            }
        }
        if(countA>n){
            return candidateA;
        }else if(countB>n){
            return candidateB;
        }else{
            return -1;
        }
    }
}

