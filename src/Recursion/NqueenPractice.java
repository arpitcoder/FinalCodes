package Recursion;

public class NqueenPractice {
    public static void main (String args[]){
        boolean[][] board=new boolean [4][4];
        printnqueen(board,0,"");
    }
    public static void printnqueen(boolean [][] board, int row, String asf){
        if(row==board.length) {
            System.out.println(asf);
            return;
        }
        for(int col=0;col<board[0].length;col++){
            if(isItSafe(board,row, col)){
                board[row][col]=true;
                printnqueen(board,row+1,asf+"["+row+"-"+col+"]");
                board[row][col]=false; // and backtracking if placed in wrong cell.
            }
        }
    }

    private static boolean isItSafe(boolean board[][], int row, int col){
        //checking whether queen is placed in the column before.
        for(int i=0;i<row;i++){
            if(board[i][col]==true){
                return false;
            }
        }
        // diagonal check "\"
        int i;
        int j;
        for(i=row-1 , j=col-1;i>=0 && j>=0;i-- ,j--){
            if(board[i][j]==true){
                return false;
            }
        }
        //diagonal check "/"
        for(i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]==true){
                return false;
            }
        }
        return true;

    }


}
