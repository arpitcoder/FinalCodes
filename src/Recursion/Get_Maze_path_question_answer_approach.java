package Recursion;

import java.util.ArrayList;

public class Get_Maze_path_question_answer_approach {
    public static void printmazepath(int cr,int cc, int er, int ec, String psf ){
        if(cr==er && cc==ec){
            System.out.println(psf);
            return;
        }
        if(cr>er || cc>ec){
            return;
        }
        printmazepath(cr,cc+1,er,ec,psf+"H");
        printmazepath(cr+1,cc,er,ec,psf+"V");
        printmazepath(cr+1,cc+1,er,ec,psf+"D");
    }
    public static void main(String args[]){
      printmazepath(0,0,4,4,"");
    }
}
