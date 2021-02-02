package Recursion;

public class solveSoduko {
    public static void main(String args[]){  // 0 signifies here those blanks where i have to fill the numbers.
        int[][] board = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
        System.out.println(solvesudoku(board));
    }
    public static boolean solvesudoku(int board[][]){
        int row=-1;
        int col=-1;
        boolean isFilled = true;
        outer: for(int i=0;i< board.length;i++){
            for(int j=0;j<board[0].length;j++){  // accessing the second dimension
                if(board[i][j]==0){
                    row=i;
                    col=j;
                    isFilled=false; // whether filled- no because I found a 0.
                    break outer;
                }
            }
        }
    if(isFilled) {  // print the elements after checking that it is filled cuz i can print only after it is filled.
        // print the board here
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
        return true; // doubt
    } // isFilled end
        for(int k=1;k<=9;k++){
            if(isSafeSudoku(k,row, col, board)){
                board[row][col]=k;
                if(solvesudoku(board)==true){ // recursive call to solvesudoku
                    return true;
                }
                else {  // backtracking ??
                    board [row][col]=0;
                }
            }
        }
        return false;  // by default false if it wasn't safe to place the number from 1 to 9.
    }

    private static boolean isSafeSudoku(int k ,int row, int col, int [][]board) {
        // keeping a column on hold and checking its rows that means i am checking in the whole column
        for(int i =0;i<=row;i++){
            if(board[i][col]==k){
                return false;
            }
        }
        //checking the different columns holding the single row
        for(int j=0;j<=col;j++){
            if(board[row][j]==k){
                return false;
            }
        }
        // repeating the box here to get the box start again
        int sqrt=(int) Math.sqrt(board.length);
        int boxRowStart = row-row%sqrt; // to again check from the start of each box to reach the nearest multiple of 3
        int boxColStart=col-col%sqrt; // to come back to the start of column here
        for(int i=boxRowStart;i<boxRowStart+sqrt;i++){
            for(int j=boxColStart;j<boxColStart+sqrt;j++){
                if(board[i][j]==k){  // agar ye number to be inserted agar na mile to return true.
                    return false;
                }
            }
        }
        return true;
    }

    }