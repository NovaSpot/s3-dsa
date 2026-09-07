import java.util.Stack;

public class PrefixToPostfix {

    public static String convert(String prefix) {
        Stack<String> stack = new Stack<>();

        // Traverse prefix expression from right to left
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            // Skip spaces if any
            if (c == ' ') continue;

            if (isOperand(c)) {
                // Operand: push as string
                stack.push(String.valueOf(c));
            } else if (isOperator(c)) {
                // Operator: pop two operands, combine, push back
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String postfixExpr = operand1 + operand2 + c;
                stack.push(postfixExpr);
            }
        }

        return stack.pop();
    }

    private static boolean isOperand(char c) {
        return Character.isLetterOrDigit(c);
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    public static void main(String[] args) {
        String prefix = "*-A/BC-/AKL";
        // Expected postfix: ABC/-AK/L-*

        String postfix = convert(prefix);
        System.out.println("Prefix   : " + prefix);
        System.out.println("Postfix  : " + postfix);
    }
}
