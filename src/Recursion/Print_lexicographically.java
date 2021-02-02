package Recursion;

public class Print_lexicographically {
    public static void main(String args[]){
        printLexico(1,1000);
    }
public static void printLexico(int num, int max){
        if(num<=max){
            System.out.println(num);
        }
    for(int i =0;i<=9;i++){
        if(num*10+i<=max);{ // this will give 10, 11 , 12....
            printLexico(num*10+i,max);
        }
    }
    if(num<9){
        printLexico(num+1, max);
    }
}
}
