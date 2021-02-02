/**Description of the question is that you have been given a array out of which you have to create k subsets and
 * you should include all the elments of the array
 * Idea is use recursion and creating list of lists that means a 2D list in which first of all we are checking that it an
 * empty list and if it an empty list then we create a list in the list and enter the first element we perform recursion
 * and then backtrack to go for the other choices that is either the element will add into the same list or create a separate
 * list
 * Else if there is a list already present then i run a for loop to access each list in the list and add the array elements
 * and perform recursion.
 * and also since we have to keep the list subsets k number we will also check that it number of set is less than k then we will create
 * a new arraylist then adding the element into the last list and then performing the recursion step and then backtracking. **/


package Recursion;

import java.util.ArrayList;

public class Kpartition_subset {
    public static void main (String args[]){
        int[] arr = { 2, 1, 4, 5, 6 };
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		kPartition(arr, 0, list, 3);
    }
    public static void kPartition(int []arr, int vidx, ArrayList<ArrayList<Integer>> list, int k){
        if(vidx== arr.length) {
            if (list.size() == k) {
                System.out.println(list);
            }
            return;
        }
        if(list.size()==0){   // its a list of a list if i dont't have any list then create a empty list and add the first array element
                                // then perform recursion and then backtrack for others possible choice of having a new subset or adding into the same list
            list.add(new ArrayList<Integer>());
            list.get(0).add(arr[vidx]);
            kPartition(arr, vidx+1,list, k);
            list.remove(0);
        }
        else{
            for(int i=0;i<list.size();i++){
                list.get(i).add(arr[vidx]);
                kPartition(arr, vidx+1, list, k);
                list.get(i).remove(list.get(i).size()-1);
            }
            if(list.size()<k){
                list.add(new ArrayList<>());  // adding a new arraylist
                list.get(list.size()-1).add(arr[vidx]); // adding this array element into the last list of the bigger list which is container of other lists
                kPartition(arr, vidx+1, list, k);
                list.remove(list.size()-1);  // backtrack by deleting the last list of the list.
            }
        }
    }
}
