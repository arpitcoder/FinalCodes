/**keep it simple and just include the base case where you will just check the block or hurdles which can be no
 * notified by either 0 or 1**/

package Recursion;

public class Rat_in_Maze_backtracking {
    public static void main (String args[]){
        System.out.println(numbermazepath(0,0,2,2));
    }
    public static int numbermazepath(int cr, int cc, int er, int ec){
        if(cr==er && cc==ec){ // first base case with value 1
            return 1;
        }
        if(cr>er || cc>ec){
            return 0;
        }
        return numbermazepath(cr+1, cc, er, ec)+numbermazepath(cr,cc+1,er, ec)+numbermazepath(cr+1, cc+1, er, ec);
    }
}
