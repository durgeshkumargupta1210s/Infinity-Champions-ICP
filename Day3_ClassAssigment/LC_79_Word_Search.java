package Day3_ClassAssigment;

public class LC_79_Word_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [][]board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";
		boolean ans=false;
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				if(board[i][j]==word.charAt(0)) {
					if(wordExist(board,i,j,word,0)) {
						ans=true;
						break;
					}
				}
			}
		}
		System.out.println(ans);
		

	}

	private static boolean wordExist(char[][] board, int cr, int cc, String word, int idx) {
		// TODO Auto-generated method stub
		
		if(idx==word.length()) {
			return true;
		}
		
		if(cr<0 || cc<0 || cr>=board.length || cc>=board[0].length || word.charAt(idx)!=board[cr][cc]) {
			return false;
		}
		char temp=board[cr][cc];
		board[cr][cc]='#';
		boolean down=wordExist(board,cr+1,cc,word,idx+1);
		boolean up=wordExist(board,cr-1,cc,word,idx+1);
		boolean right=wordExist(board,cr,cc+1,word,idx+1);
		boolean left=wordExist(board,cr,cc-1,word,idx+1);
		
		board[cr][cc]=temp;
		
		return down || up || right || left;
	}

}
