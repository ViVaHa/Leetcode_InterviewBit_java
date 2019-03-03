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
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length==0){
            return 0;
        }
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            startTimes[i] = intervals[i].start;
            endTimes[i] = intervals[i].end;
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        int start=1;
        int end=0;
        int rooms=1;
        int maxRooms=1;
        while(start<intervals.length && end<intervals.length){
            if(startTimes[start]<endTimes[end]){
                rooms+=1;
                start+=1;
                maxRooms = Math.max(maxRooms,rooms);
            }else{
                rooms-=1;
                end+=1;
            }
        }
        return maxRooms;
    }
}
