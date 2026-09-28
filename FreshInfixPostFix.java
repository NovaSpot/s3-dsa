import java.util.*;
import java.io.*;

public class Program{
    public static void main(String str[]){
        System.out.print("Enter a infix string");
        Scanner sc = new Scanner(System.in);
        String infix_string = sc.nextLine();
        infix_string = reverse(infix_string);
        System.out.println(infix_string);
        Stack postfixStack =new Stack();
        for(int i=0;i<infix_string.length();i++){
            char k = infix_string.charAt(i);
            //System.out.println(k);
            if(Character.isWhitespace(k)) continue;
            if(Character.isLetterOrDigit(k)){
                System.out.print(k);
            }else if(isLeftBracket(k)){
                postfixStack.push(k);
            }else if(isRightBracket(k)){
                while(postfixStack.peek()!='('){
                    System.out.print(postfixStack.pop());
                }
                postfixStack.pop();
            }else if(isOperator(k)){
                while(!postfixStack.isEmpty()&&isHigherOrEqual(postfixStack.peek(),k)){
                    System.out.print(postfixStack.pop());
                }
                postfixStack.push(k);
            }
        }
        while(!postfixStack.isEmpty()){
            System.out.print(postfixStack.pop());
        }
    }
    static boolean isLeftBracket(char l){
        return(l=='(');
    }
    static boolean isRightBracket(char j){
        return(j==')');
    }
    static boolean isOperator(char m){
        return(m=='+'||m=='-'||m=='*'||m=='^'||m=='/');
    }
    static boolean isHigherOrEqual(char o, char s){
        return(precedence(o)>precedence(s));
    }
    static int precedence(char q){
        if(q=='+'||q=='-') return 1;
        else if(q=='*'||q=='/') return 2;
        else if(q=='^') return 3;
        else return 0;
    }
    public static String reverse(String str) {
    if (str.isEmpty()) return str;
    return reverse(str.substring(1)) + str.charAt(0);
    }
}

class Stack{
    char[] arr = new char[50];
    int top=-1;
    public void push(char c){
        arr[++top]=c;
    }
    public char pop(){
        return(arr[top--]);
    }    
    public char peek(){

        return(arr[top]);
    }
    public boolean isEmpty(){
        return(top==-1);                
    }

}