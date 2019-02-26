class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((p1,p2)->{
            return (p2[0]*p2[0] + p2[1]*p2[1]) - (p1[0]*p1[0] + p1[1]*p1[1]);
        });
        for(int[] point : points){
            queue.offer(point);
            if(queue.size()>K){
                queue.poll();
            }
        }
        int[][] closestPoints = new int[K][2];
        for(int i=0;i<K;i++){
            closestPoints[i] = queue.poll();
        }
        return closestPoints;
    }
}
