/**There is a variation in this question where we only want those subsets in which subset sum is equal and then k subsets
 * suppose i want a subsets {{5},{1,4},{3,2},{2,3}} these are 4 subsets with equal sum **/

package Recursion;

import java.util.ArrayList;

public class kPartitionSubsetsum {
    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        int subsetsum[] = new int[4]; // this will have list array size of 4 elements in each list of the list.
        int arr[]=  { 4,3,2,3,5,2,1};
        kpartitionSubsetsum(arr,0,list,4,subsetsum);
    }
    public static void kpartitionSubsetsum(int arr[], int vidx, ArrayList<ArrayList<Integer>> list, int k , int[] subsetsum){
        if(vidx== arr.length){ // if it is the last element of the array to be taken into consideration
            if(list.size()==k){
                for(int i=1;i<k;i++){
                    if(subsetsum[i]!=subsetsum[i-1]){
                        return;
                    }
                }
                System.out.println(list);
            }
            return;
        }
        if(list.size()==0){
            list.add(new ArrayList<Integer>());
            list.get(0).add(arr[vidx]);
            subsetsum[0]+=arr[vidx];
            kpartitionSubsetsum(arr, vidx+1, list, k, subsetsum);
            list.remove(0);  // backtracking to go for other choices
            subsetsum[0]-=arr[vidx]; // have to also subtract the subsetsum in the first index;
        }
        else{
            for(int i =0;i<list.size();i++){
                list.get(i).add(arr[vidx]); // else bring the list and add the elements in those list
                subsetsum[i]+=arr[vidx];
                kpartitionSubsetsum(arr, vidx+1, list, k, subsetsum);
                subsetsum[i]-=arr[vidx];
                list.get(i).remove(list.get(i).size()-1); // removing that last element of the list of the list
            }
            if(list.size()<k){
                list.add(new ArrayList<Integer>());
                list.get(list.size()-1).add(arr[vidx]);
                subsetsum[list.size()-1]+=arr[vidx];
                kpartitionSubsetsum(arr, vidx+1, list, k, subsetsum);
                subsetsum[list.size()-1]-=arr[vidx];
                list.remove(list.size()-1);
            }
        }
    }
}
