public class WordSearch {

	private static boolean existHelp(char[][] board, String word, int i, int j, int count) {
        if(count==word.length())return true;
        if(i<0 ||i>=board.length ||j<0||j>=board[i].length||board[i][j]!=word.charAt(count)){
        return false;
        }
        Character temp = board[i][j];
        board[i][j]=' ';
        boolean found = existHelp(board,word,i+1,j,count+1) || 
        existHelp(board,word,i-1,j,count+1) ||
        existHelp(board,word,i,j+1,count+1) || 
        existHelp(board,word,i,j-1,count+1);
        board[i][j] =temp;
        return found;
    }

    public static boolean exist(char[][] board, String word) {
        for(int i =0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0) && existHelp(board,word,i,j,0))
                return true;
            }
        }
        return false;
    }
	public static void main(String[] args) {
		char [][]board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'},
		};
		String word = "ABCCEE";
		System.out.println(exist(board, word)?"Word exists ":"Word doesn't exist");
	}

}
