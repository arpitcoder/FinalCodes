/**basic example of backtracking is n queen and there is a matrix and i have to place the n queens such that
 * no two queens attack each other.**/

package Recursion;

public class NQueens_problem {
    public static void main(String args[]){
        boolean board[][]=new boolean[4][4];
        printNQueens(board,0,"");
    }
    public static void printNQueens(boolean[][] board, int row, String asf) { // current row in which i have to place queen
        if ( row==board.length) {
            System.out.println(asf);
            return;
        }
        // we have to check that in which column we have to place the queen so we are running loop for every single col
        for (int col = 0; col < board[0].length; col++) {
            if (isItSafe(board, row, col)) {
                board[row][col] = true;   // holding each row and then checking the column and then after recursion inc rows
                printNQueens(board, row + 1, asf + "[" + row + "-" + col + "]"); // row is increasing as i have to see whether in that row i can place the queen or not.
                board[row][col] = false;  // un-placing it first and then again doing backtracking.
            }
        }
    }
  // agar ye function mujhe safe to go ahead dega to hi mai aagea proceed karunga
    private static boolean isItSafe(boolean[][] board, int row, int col) {
        //for column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == true) {
                return false;
            }
        }
        //diagonal 1            /** diagonal of "\" **/
        int r = row -1;
        int c = col - 1;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == true) {
                return false;
            }
            r--;
            c--;
        }
        //diagonal 2       diagonal of "/" just imagine and then draw and write your code
        r = row - 1;
        c = col + 1;
        while (r >= 0 && c<board[0].length) {
            if (board[r][c] == true) {
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
}

