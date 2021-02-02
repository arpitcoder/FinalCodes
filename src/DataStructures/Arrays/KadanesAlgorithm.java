package DataStructures.Arrays;
import java.util.*;
public class KadanesAlgorithm {
    public static int kadanesmaxsubarray(int arr[]) {
        int maxsofar = Integer.MIN_VALUE;
        int maxend = 0; // it will store the sum of array elements and keep adding and checking with maxsofar and making this sum to zero if find the sum of ele less than zero
        for (int i = 0; i < arr.length; i++) {
            maxend = maxend + arr[i];
            if (maxsofar < maxend) {
                maxsofar = maxend;
            } else if (maxend < 0) {
                maxend = 0;
            }
        }
        return maxsofar;
    }


    public static void main (String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int array[]=new int [n];
        for(int i=0;i<array.length;i++){
            array[i]=input.nextInt();
        }
        System.out.println(kadanesmaxsubarray(array));
    }
}
