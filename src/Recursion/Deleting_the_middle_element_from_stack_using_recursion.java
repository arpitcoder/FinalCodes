package Recursion;
import java.util.Stack;

public class Deleting_the_middle_element_from_stack_using_recursion {
    public static void main(String args[]){
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(deleteMiddleitem(stack));
    }

    public static Stack<Integer> deleteMiddleitem(Stack<Integer> stack) {
        int middle =stack.size()/2+1;
        if(stack.size()==0){
            return stack;
        }
        solve(stack,middle);
        return stack;
    }
    public static void solve(Stack<Integer> stack, int middle){
        if (middle==1){  //first element in the stack is the middle element to be deleted
            stack.pop();
            return;
        }
        int temp=stack.peek();
        stack.pop();
        solve(stack,middle-1);  // after popping one element now the middle element is decremented by one
        stack.push(temp);
        return;
    }
}
