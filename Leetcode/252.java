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
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals.length==0){
            return true;
        }
        int startTimes[] = new int[intervals.length];
        int endTimes[] = new int[intervals.length];
        for(int i=0; i<intervals.length; i++){
            startTimes[i] = intervals[i].start;
            endTimes[i] = intervals[i].end;
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        int i=0;
        int j=1;
        while(j<intervals.length){
            if(startTimes[j]<endTimes[i]){
                return false;
            }
            i+=1;
            j+=1;
        }
        return true;
    }
}
