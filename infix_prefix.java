import java.util.*;

class InfixToPrefix {

  private static int getPrecedence(char ch) {
    switch (ch) {
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
        return 2;
      case '^':
        return 3;
      default:
        return -1;
    }
  }
  
  public static String convert(String expr) {
    if (expr == null || expr.trim().isEmpty()) {
      throw new IllegalArgumentException("Expression cannot be null or empty.");
    }
    
    StringBuilder reversedExpr = new StringBuilder(expr).reverse();
    
    for (int i = 0; i < reversedExpr.length(); i++) {
      char c = reversedExpr.charAt(i);
      if (c == '(') {
        reversedExpr.setCharAt(i, ')');
      } else if (c == ')') {
        reversedExpr.setCharAt(i, '(');
      }
    }
    
    StringBuilder result = new StringBuilder();
    Stack<Character> stack = new Stack<>();
    
    for (int i = 0; i < expr.length(); i++) {
      char c = expr.charAt(i);
      
      if (Character.isWhitespace(c)) continue;
      
      if (Character.isLetterOrDigit(c)) {
        result.append(c);
      }
      
      else if (c == '(') {
        stack.push(c);
      }
      
      else if (c == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          result.append(stack.pop());
        }
        if (stack.isEmpty()) {
          throw new IllegalArgumentException("Invalid expression: Mismatched parenthesis (missing '(').");
        }
        stack.pop();
      }
      
      else if (getPrecedence(c) > 0) {
        while (!stack.isEmpty() && stack.peek() != '(') {
          int precedenceTop = getPrecedence(stack.peek());
          int precedenceCurrent = getPrecedence(c);
          
          if (precedenceTop > precedenceCurrent || (precedenceTop == precedenceCurrent && c != '^')) {
            result.append(stack.pop());
          } else {
            break;
          }
        }
        stack.push(c);
      }
      
      else {
        throw new IllegalArgumentException("Invalid character encountered: " + c);
      }
    }
    
    while (!stack.isEmpty()) {
      if (stack.peek() == '(') {
        throw new IllegalArgumentException("Invalid expression: Mismatched parenthesis (missing ')').");
      }
      result.append(stack.pop());
    }
    
    return result.reverse().toString();
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a infix string: ");
    String in = sc.nextLine();
    sc.close();
    
    try {
      System.out.println(convert(in));
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
    }
  }

}
