package Branching_Recursion;
//Rat in a Maze (Rat Move to Up , Left, Right, Down)
public class advance_Rat_in_a_maze {
	static boolean isNotBlocked(int[][] board,int row,int col) {
		if(row<board.length &&col<board.length&&board[row][col]==1) {
			return true;
		}
		return false;
	}

	static boolean ratInMaze(int board[][],int row,int col,int path[][]) {
		 if (row < 0 || col < 0 || row >= board.length || col >= board[row].length || path[row][col] == 1 || board[row][col] == 0) {
		        return false;
		    }

		    if (row == board.length - 1 && col == board[row].length - 1) {
		        path[row][col] = 1;
		        return true;
		    }
		if(isNotBlocked(board,row,col)) {
			path[row][col]=1;
			if(ratInMaze(board,row+1,col,path)){//right 
				return true;
			}if (ratInMaze(board,row,col+1,path)){//down 
				return true;
			}
			if(ratInMaze(board,row-1,col,path)) {//left
				return true;
			}
			if(ratInMaze(board,row,col-1,path)) {//up
				return true;
			}
			path[row][col]=0;
			
		}
		return false;
	}
	public static void main(String[] args) {
		int [][] board= {
				{ 1,0,1,0,1},
				{1,1,1,1,1},
				{0,1,0,1,0},
				{1,0,0,1,1},
				{1,1,1,0,1}
		};
		int path[][]=new int[board.length][board.length];
		boolean result=ratInMaze(board,0,0,path);
		  if(result){
              System.out.println("Rat Reach and Path Follow...");
          for(int i =0; i<path.length; i++){
              for(int j = 0; j<path[i].length; j++){
                  System.out.print(path[i][j]+" ");
              }
              System.out.println();
          }
      }
      else{
          System.out.println("Rat Not Reached...");
      }
		
	}
	}


