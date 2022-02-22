import java.util.Arrays;

public class SudokuProject{
    int[][] puzzle;

    //Constructor
    public SudokuProject(){
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

        puzzle = new int[9][9];
        puzzle = sudokuPuzzle;

        for(int[] x : puzzle)
        if(sudokuSolver()){
            System.out.println(Arrays.toString(x)); 
        }else{
           System.out.println("No Solution");
        }
    }

    public boolean sudokuSolver(){
        for(int r = 0; r < puzzle[0].length; r++){
            for(int c = 0; c < puzzle.length; c++){
                if(puzzle[r][c] == 0){
                    for(int i = 1; i < 10; i++){
                        if(isValid(r, c, i)){
                            puzzle[r][c] = i;
                            if(sudokuSolver())
                                return true;
                            puzzle[r][c] = 0;
                        }
                    }
                return false;
                }
            }
        }
        return true;
    }

    //Check if input is in row
    public boolean rowValid(int row, int input){
        for(int c = 0; c < 9; c++)
            if(puzzle[row][c] == input)
                return true;

        return false;
    }

    //Check if input is in column
    public boolean colValid(int col, int input){
        for(int r = 0; r < 9; r++)
            if(puzzle[r][col] == input)
                return true;

        return false;
    }

    //Checks the 9 3x3 boxes for 'input'
    public boolean boxValid(int row, int col, int input){
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
    public boolean isValid(int row, int col, int input){
        return !rowValid(row, input) && !colValid(col, input) && !boxValid(row, col, input);
    }

    //Main Method
    public static void main(String[] args){
       new SudokuProject();
    }
}