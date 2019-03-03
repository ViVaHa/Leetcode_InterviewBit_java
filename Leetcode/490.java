class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int destX = destination[0];
        int destY = destination[1];
        Queue<Point> queue = new LinkedList<>();
        boolean [][] visited = new boolean[maze.length][maze[0].length];
        int[] xDirections = new int[] {0,0,-1,1};
        int[] yDirections = new int[] {1,-1,0,0};
        queue.add(new Point(start[0],start[1]));
        while(queue.size()>0){
            Point point = queue.poll();
            if(point.x == destX && point.y == destY){
                return true;
            }
            int x = point.x;
            int y = point.y;
            
            for(int i=0;i<4;i++){
                x = point.x;
                y = point.y;
                while(x+xDirections[i]>=0 && y+yDirections[i]>=0 && x+xDirections[i]<maze.length && y+yDirections[i]<maze[0].length && maze[x+xDirections[i]][y+yDirections[i]]==0){
                    x+=xDirections[i];
                    y+=yDirections[i];
                }
                if(!visited[x][y]){
                    queue.add(new Point(x,y));
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }
}
