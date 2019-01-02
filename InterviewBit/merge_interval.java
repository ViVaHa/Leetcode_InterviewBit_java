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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int i=0;
        ArrayList<Interval> finalList = new ArrayList<>();
        boolean found=false;
        while(i<intervals.size() && intervals.get(i).end<newInterval.start){
            finalList.add(intervals.get(i));
            i+=1;
        }
        if(i==intervals.size()){
            finalList.add(newInterval);
            return finalList;
        }
        else{
            while(i<intervals.size() && intervals.get(i).start<=newInterval.end){
                newInterval.start=Math.min(newInterval.start,intervals.get(i).start);
                newInterval.end=Math.max(newInterval.end,intervals.get(i).end);
                i+=1;
            }
            finalList.add(newInterval);
            while(i<intervals.size()){
                finalList.add(intervals.get(i));
                i+=1;
            }
            return finalList;
        }
    }
}

