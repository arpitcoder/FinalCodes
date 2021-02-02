package Recursion;

import java.util.*;

public class Sorting_Stack_using_recursion {

    public static Stack<Integer> insertInstack(Stack<Integer> smallstack, int storeattop){
        if(smallstack.isEmpty() || smallstack.peek()<=storeattop) {
            smallstack.push(storeattop);
            return smallstack;
        }
        int temp=smallstack.peek();
        smallstack.pop();
        insertInstack(smallstack,storeattop);
        smallstack.push(temp);
        return smallstack;
    }
        public static Stack<Integer> sortusingrecursion(Stack<Integer>stack){
         if(stack.isEmpty()){
             return stack;
         }
            int storeattop=stack.peek();
            //Stack<Ier> smallstack=new Stack<>();
            stack.pop();
            sortusingrecursion(stack);
            insertInstack(stack, storeattop);
            return stack;

        }
    public static void main(String args[]) {
        Stack<Integer> stack=new Stack<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i =0;i<n;i++) {
            int item= input.nextInt();
            stack.push(item);
        }
        input.close();
        // System.out.println(stack);
        System.out.println(sortusingrecursion(stack));
    }
}