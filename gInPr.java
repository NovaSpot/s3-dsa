import java.util.Scanner;

public class InfixToPrefix {
    static class CharStack {
        int top = -1;
        char[] arr = new char[1000];

        void push(char c) {
            arr[++top] = c;
        }

        char pop() {
            return arr[top--];
        }

        char peek() {
            return arr[top];
        }

        boolean isEmpty() {
            return top == -1;
        }
    }

    static int precedence(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        if (c == '^') return 3;
        return -1;
    }

    static boolean isOperand(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    static String reverse(String s) {
        String res = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            res += s.charAt(i);
        }
        return res;
    }

    static String convert(String expr) {
        String rev = "";
        for (int i = expr.length() - 1; i >= 0; i--) {
            char c = expr.charAt(i);
            if (c == '(') {
                rev += ')';
            } else if (c == ')') {
                rev += '(';
            } else {
                rev += c;
            }
        }

        String postfix = "";
        CharStack stack = new CharStack();

        for (int i = 0; i < rev.length(); i++) {
            char c = rev.charAt(i);

            if (isOperand(c)) {
                postfix += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) < precedence(stack.peek())) {
                    postfix += stack.pop();
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }

        return reverse(postfix);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Infix Expression: ");
        String expr = sc.nextLine();
        System.out.println("Prefix Expression: " + convert(expr));
    }
}
