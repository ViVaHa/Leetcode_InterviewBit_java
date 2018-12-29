/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedList=new ArrayList<>();
        if(intervals.size()==0){
            return mergedList;
        }
        Collections.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start-b.start;
            }
        });
        int i=0;
        int j=1;
        mergedList.add(intervals.get(0));
        while(j<intervals.size()){
            Interval a=mergedList.get(i);
            Interval b=intervals.get(j);
            if(a.end>=b.start){
                a.end=Math.max(a.end,b.end);
                mergedList.set(i,a);
            }else{
                mergedList.add(b);
                i+=1;
            }
            j+=1;
        }
        return mergedList;
    }
}
