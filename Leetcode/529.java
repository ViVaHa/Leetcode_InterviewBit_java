public class Node{
    public int x;
    public int y;
    Node(int x,int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public boolean isSafe(int x, int y, char visited[][]){
        if(x>=0  && y>=0 && x<visited.length && y<visited[x].length){
            return true;
        }
        return false;
    }
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board.length==0){
            return board;
        }
        Node start = new Node(click[0],click[1]);
        boolean visited[][] = new boolean[board.length][board[0].length];
        int[] x_directions = new int[]{-1,-1,-1,0,0,1,1,1};
        int[] y_directions = new int[]{-1,0,1,-1,1,-1,0,1};
        char[][] newBoard = board;
        
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        while(queue.size()>0){
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            if(board[x][y]=='M'){
                newBoard[x][y] = 'X';
                break;
            }
            int count=0;
            if(board[x][y]=='E'){
                for(int i=0;i<=7;i++){
                    if(isSafe(x+x_directions[i],y+y_directions[i],board)){
                        if(newBoard[x+x_directions[i]][y+y_directions[i]]=='M' || newBoard[x+x_directions[i]][y+y_directions[i]]=='X'){
                            count+=1;
                        }
                    }
                }
                if(count==0){
                   for(int i=0;i<=7;i++){
                        if(isSafe(x+x_directions[i],y+y_directions[i],board)){
                            if(newBoard[x+x_directions[i]][y+y_directions[i]]=='E'){
                                queue.offer(new Node(x+x_directions[i],y+y_directions[i]));
                            }
                        }
                    } 
                    if(newBoard[x][y]=='E')
                        newBoard[x][y] = 'B';
                }else{
                    newBoard[x][y] = (char)(count + '0');
                }

            }
            
        }
        return newBoard;
    }
}
