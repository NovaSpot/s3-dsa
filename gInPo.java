import java.util.Scanner;

public class InfixToPostfix {
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

    static String convert(String expr) {
        String result = "";
        CharStack stack = new CharStack();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (c == ' ') {
                continue;
            }

            if (isOperand(c)) {
                result += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    if (c == '^' && stack.peek() == '^') break;
                    result += stack.pop();
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Infix Expression: ");
        String expr = sc.nextLine();
        System.out.println("Postfix Expression: " + convert(expr));
    }
}