/* Ref: https://www.youtube.com/watch?v=IY0nZLEg6MA */

import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        String eqn = "2*3+5";
        evaluate(eqn);
    }

    private static void evaluate(String eqn) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < eqn.length(); i++) {
            char c = eqn.charAt(i);
            if (c == '(') {
                operators.push(c);
            } else if (Character.isDigit(c)) {
                operands.push(c - '0');
            } else if (c == ')') {
                while (operators.peek() == '(') {
                    char opr = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();
                    operands.push(operation(v1, v2, opr));
                }
                operators.pop();
            } else {
                while (operators.size() > 0 && operators.peek() != '('
                        && precedence(c) <= precedence(operators.peek())) {
                    char opr = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();
                    operands.push(operation(v1, v2, opr));
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            char opr = operators.pop();
            int v2 = operands.pop();
            int v1 = operands.pop();
            operands.push(operation(v1, v2, opr));
        }

        System.out.println(eqn + " = " + operands.peek());
    }

    private static int precedence(char operator) {
        if (operator == '+' || operator == '-')
            return 1;
        else
            return 2;
    }

    private static int operation(int v1, int v2, char operator) {
        if (operator == '+')
            return v1 + v2;
        else if (operator == '-')
            return v1 - v2;
        else if (operator == '*')
            return v1 * v2;
        else
            return v1 / v2;
    }
}
