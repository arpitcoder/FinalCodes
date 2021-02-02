package Recursion;

import java.util.ArrayList;

public class balanceParenthesis {
    public static void main(String args[]){
        ArrayList<String> list = new ArrayList<>();
        balanceParenthesis("()())()","",0,0,7,list);
        int max=0;
        for(String str:list){
            max=Math.max(str.length(),max); // giving me the max ans like in this case i have max length of 6 balance parenthesis
        }
        for(String str:list){
            if(str.length()==max){  // printing only those which gives me the max string list run and see the answer
                System.out.println(str);
            }
        }
    }
    public static void balanceParenthesis(String ques, String ans, int obkt, int cbkt, int n, ArrayList<String> list){
    if(cbkt>obkt){
        return;
    }
    if(obkt>n/2){  // this is the length of the ques string actually logic is that to be a balanced paranthesis it cannot be greater than half the length of the string
        return;
    }
    if(ques.length()==0){
        if(obkt==cbkt){
            System.out.println(ans);
            list.add(ans);
        }
        return;
    }
    char ch=ques.charAt(0);
    String ros=ques.substring(1);
    if(ch=='('){
        balanceParenthesis(ros,ans+ch,obkt+1, cbkt, n , list);
    }
    else{
        balanceParenthesis(ros, ans+ch, obkt, cbkt+1, n , list);
    }
    balanceParenthesis(ros, ans, obkt, cbkt, n , list);
    }
}
