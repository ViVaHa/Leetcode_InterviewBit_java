public class Solution {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        if(A.size()==0){
            return new ArrayList<Integer>();
        }
        long maxSubArray=-1;
        long sumTillNow=-1;
        int finalStart=-1;
        int finalEnd=-1;
        int maxLength=0;
        int startIndex=-1;
        int i;
        int start=-1,end=-1;
        for(i=0;i<A.size();i++){
            if(A.get(i)>=0){
                if(sumTillNow==-1){
                    start=i;
                    sumTillNow=0;
                }
                sumTillNow+=A.get(i);
            }else{
                if(sumTillNow>=0){
                    end=i-1;
                    if(sumTillNow>maxSubArray){
                        finalStart=start;
                        finalEnd=end;
                        maxSubArray=sumTillNow;
                        maxLength=end-start+1;
                    }else if(sumTillNow==maxSubArray){
                        if(end-start+1>maxLength){
                            finalStart=start;
                            finalEnd=end;
                            maxLength=end-start+1;
                        }
                    }
                }
                sumTillNow=-1;
            }
        }
        if(sumTillNow>-1){
            if(sumTillNow>maxSubArray){
                finalStart=start;
                finalEnd=i-1;
            }else if(sumTillNow==maxSubArray){
                if(i-1-start+1>maxLength){
                    finalStart=start;
                    finalEnd=i-1;
                }
            }
        }
        //System.out.println(finalStart);
        if(finalStart==-1 && finalEnd==-1){
            return new ArrayList<Integer>();
        }else{
            ArrayList<Integer> list = new ArrayList<>();
            for(i=finalStart;i<=finalEnd;i++){
                list.add(A.get(i));
            }
            return list;
        }
    }
}

