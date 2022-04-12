public class ChessProject {
    public final static boolean QUEEN = true;
    public final static boolean EMPTY = false;

    public ChessProject(){
        boolean[][] chessBoard = new boolean[8][8];
        for(int r = 0; r < chessBoard[0].length; r++)
            for(int c = 0; c < chessBoard.length; c++)
                chessBoard[r][c] = EMPTY;

        eightQueens(chessBoard, 0);
        System.out.println(displayBoard(chessBoard));
    }

    public static String displayBoard(boolean[][] board){
        String boardString = "Chess Board:\n";
        int count = 0;
        for(boolean[] x : board)
            for(boolean y : x){
                if(y == QUEEN)
                    boardString += "X ";
                else
                    boardString += "0 ";

                count++;
                if(count % 8 == 0)
                    boardString += "\n";
            }

        return boardString;
    }

    public boolean canPlace(boolean[][] board, int row, int col){
        //Check Left
        for(int i = 0; i < col; i++)
            if(board[row][i] == QUEEN)
                return false;
        
        //Check Top Diagonal
        int r, c;
        for(r = row, c = col; r >= 0 && c >= 0; r--, c--)
            if(board[r][c] == QUEEN)
                return false;
        
        //Check Bottom Diagonal
        for(r = row, c = col; r < 8 && c >= 0; r++, c--)
            if(board[r][c] == QUEEN)
                return false;

        return true;
    }

    public boolean eightQueens(boolean[][] board, int col){
        if(col > board.length)
            return true;
        
        for(int r = 0; r < board[0].length; r++){
            if(canPlace(board, r, col)){
                board[r][col] = QUEEN;

                if(eightQueens(board, col + 1))
                    return true;

                board[r][col] = EMPTY;
            }
        }
        return false;
    }

    public static void main(String[] args){
        new ChessProject();
    }
}
