class Solution {
    public int orangesRotting(int[][] grid) {

        int inputLengthX = grid.length;
        int inputLengthY = grid[0].length;

        Queue<Node> q = new LinkedList<>();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 2){
                    q.add(new Node(i, j, 0));
                }
            }   
        }

        int t=0;
        while(!q.isEmpty()){

            int tmpX = q.peek().x;
            int tmpY = q.peek().y;
            
            if(tmpX > 0){
                if(grid[tmpX-1][tmpY] == 1){
                    q.add(new Node(tmpX-1, tmpY, t+1));
                    grid[tmpX-1][tmpY] = 2;
                }
            }
            if(tmpY > 0){
                if(grid[tmpX][tmpY-1] == 1){
                    q.add(new Node(tmpX, tmpY-1, t+1));
                    grid[tmpX][tmpY-1] = 2;
                }
            }
            if(tmpX+1 < inputLengthX){
                if(grid[tmpX+1][tmpY] == 1){
                    q.add(new Node(tmpX+1, tmpY, t+1));
                    grid[tmpX+1][tmpY] = 2;
                }
            }

            if(tmpY+1 < inputLengthY){
                if(grid[tmpX][tmpY+1] == 1){
                    q.add(new Node(tmpX, tmpY+1, t+1));
                    grid[tmpX][tmpY+1] = 2;
                }
            }

            q.remove();

            if(!q.isEmpty() && q.peek().set == t+1){
                t++;
            }
        }

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return t;
    }
    
    public class Node{
        int set;
        int x, y;
        
        Node(int x, int y, int set){
            this.x = x;
            this.y = y;
            this.set = set;
        }
    }
}