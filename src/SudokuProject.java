import java.util.Arrays;

public class SudokuProject{
    private int row, col;

    //Constructor
    public SudokuProject(){
        row = -1;
        col = -1;
        int[][] sudokuPuzzle = {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        sudokuSolver(sudokuPuzzle);
            for(int[] x : sudokuPuzzle)
                System.out.println(Arrays.toString(x)); 
       // }else{
           // System.out.println("No Solution");
        //}
    }

    public boolean sudokuSolver(int[][] puzzle){
        if(!isEmpty(puzzle))
            return true;
        
        for(int i = 1; i < 10; i++)
            if(isValid(puzzle, i)){
                puzzle[row][col] = i;
                if(sudokuSolver(puzzle))
                    return true;
                puzzle[row][col] = 0;
            }

        return false;
    }

    //Check if input is in row
    public boolean rowValid(int[][] puzzle, int input){
        for(int c = 0; c < 9; c++)
            if(puzzle[row][c] == input)
                return true;

        return false;
    }

    //Check if input is in column
    public boolean colValid(int[][] puzzle, int input){
        for(int r = 0; r < 9; r++)
            if(puzzle[r][col] == input)
                return true;

        return false;
    }

    //Checks the 9 3x3 boxes for 'input'
    public boolean boxValid(int[][] puzzle, int input){
        int r = row - row % 3;
        int c = col - col % 3;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(puzzle[r + i][c + j] == input)
                    return true;
            }
        }
        
        return false;
    }

    //Checks for valid input
    public boolean isValid(int[][] puzzle, int input){
        return !rowValid(puzzle, input) && !colValid(puzzle, input) && !boxValid(puzzle, input);
    }

    //Finds empty spaces
    public boolean isEmpty(int[][] puzzle){
        for(int r = 0; r < puzzle[0].length; r++)
            for(int c = 0; c < puzzle.length; c++)
                if(puzzle[r][c] == 0){
                    row = r;
                    col = c;
                    return true;
                }
                
        return false;
    }

    //Main Method
    public static void main(String[] args){
       new SudokuProject();
    }
}