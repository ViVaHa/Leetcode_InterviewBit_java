/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a,Interval b){
                return a.start-b.start;
            }
        });
        ArrayList<Interval> finalList = new ArrayList<>();
        finalList.add(intervals.get(0));
        int i=0;
        int j=1;
        while(j<intervals.size()){
            if(intervals.get(j).start>finalList.get(i).end){
                finalList.add(intervals.get(j));
                i+=1;
                j+=1;
            }else{
                Interval merged=finalList.get(i);
                merged.end=Math.max(merged.end,intervals.get(j).end);
                finalList.set(i,merged);
                j+=1;
            }
        }
        return finalList;
    }
}

