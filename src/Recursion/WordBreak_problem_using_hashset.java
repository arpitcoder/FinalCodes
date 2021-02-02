package Recursion;

import java.util.HashSet;

public class WordBreak_problem_using_hashset {
    public static void main(String args[]){
        HashSet<String> hashSet=new HashSet<>();
        hashSet.add("i");
        hashSet.add("like");
        hashSet.add("sam");
        hashSet.add("sung");
        hashSet.add("samsung");
        hashSet.add("mobile");
        hashSet.add("ice");
        hashSet.add("cream");
        hashSet.add("icecream");
        hashSet.add("man");
        hashSet.add("go");
        hashSet.add("mango");
        wordBreak("ilikesamsungmobile", "",hashSet);
    }
    public static void wordBreak(String ques, String ans, HashSet<String> dictionary){
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<=ques.length();i++){
            String cutString = ques.substring(0,i);
            if(dictionary.contains(cutString)){
                String restques = ques.substring(i);
                wordBreak(restques,ans+" "+cutString,dictionary); // recursive call to go and do that to make a tree and bringing all the possible dictionary words
            }
        }
       // return;
    }
}
