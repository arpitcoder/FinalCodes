/**This will return the number of the board paths as the function return type will be int and we will not be using
 * golbal counter variable**/
package Recursion;

public class numberofboardpaths {
    public static void main (String args[]){
        System.out.println(numberofboardpaths(0,10));
    }
    public static int numberofboardpaths(int curr, int end){
        if(curr==end){
            return 1;
        }
        if(curr>end){
            return 0;
        }
        int count=0;
        for(int i =1;i<=6;i++){
            count+=numberofboardpaths(curr+i,end);
        }
        return count;
    }
}
