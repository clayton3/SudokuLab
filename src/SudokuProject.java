import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SudokuProject{
    int[][] puzzle;

    //Constructor
    public SudokuProject(int[][] sudokuPuzzle){
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
    public static void main(String[] args) throws FileNotFoundException{
        Scanner scan = new Scanner(new File("p096_sudoku.txt"));
        String num = "";
        List<String> grids = new ArrayList<>();
        int gridCount = 0;
        while(scan.hasNextLine()){
            num = scan.nextLine();
            if(!num.contains("Grid"))
                grids.add(num);
            else
                gridCount++;

        }

        List<Integer> singleNum = new ArrayList<>();
        for(int i = 0; i < grids.size(); i++)
            for(int j = 0; j < 9; j++)
                singleNum.add(Integer.parseInt(grids.get(i).substring(j, j+1)));

        //System.out.println(singleNum);
        
        int[][] sudoku = new int[9][9];

        //for(int[] x : sudoku)
          //  System.out.println(Arrays.toString(x));
        for(int i = 0; i < gridCount; i++){
            int count = 0;
            for(int r = 0; r < sudoku[0].length; r++){
                for(int c = 0; c < sudoku.length; c++){
                    sudoku[r][c] = singleNum.get(count);
                    count++;
                }
            }
            for(int j = 0; j < 81; j++)
                System.out.print(singleNum.remove(j));

            System.out.println("\n");

            //System.out.println("Grid " + (i+1));
            //new SudokuProject(sudoku);
        }
    }
}