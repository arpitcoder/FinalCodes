/** this is returning me the no of paths**/

package Recursion;

public class Get_printboardPath {
     static int count=0; // this will give me the count of the number of paths to reach the end from the source
    public static void printboardpath(int curr, int end, String ans){
        if(curr==end){
            count++;
            System.out.println(ans);
            return;
        }
        if(curr>end) {
            return;  // do nothing and just return
        }
        for(int i=1; i<=6;i++){
            printboardpath(curr+i,end, ans+i);
        }
       // return;
    }
    public static void main(String args[]){
        printboardpath(0,10,"");// passing it to the function by value and java doesn't support passing by reference
        System.out.println(count);
    }
}
/**int numberofpath(int curr, int end)
 * if(cur==end)
 *   return
 *   if(cur>end)
 *      return 0
 *   int count=0;
 *    for(int i=1;i<=6;i++){
 *      count+=numberofpaths(curr+i,end);
 *      return
 *      }
 *     return count; ;**/