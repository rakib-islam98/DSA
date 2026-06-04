import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        // String operators = "+-/*";
        for(String token : tokens) {
            switch (token) {
                case "+", "-", "*", "/" -> {
                    // operator logic
                    int op2 = stack.pop();
                    int op1 = stack.pop();

                    int res = switch(token) {
                        case "+" -> op1 + op2;
                        case "-" -> op1 - op2;
                        case "*" -> op1 * op2;
                        case "/" -> op1 / op2;
                        default -> 0; // not going to execute
                    };
                    stack.push(res);
                }
                default -> {
                    stack.push(Integer.valueOf(token));
                }
            }
            // if(str.length() == 1 && operators.contains(str)) {
            //     int op2 = stack.pop();
            //     int op1 = stack.pop();
            //     stack.push(switch(str) {
            //         case "+" -> op1 + op2;
            //         case "-" -> op1 - op2;
            //         case "*" -> op1 * op2;
            //         case "/" -> op1 / op2;
            //         default -> 0; // not going to execute
            //     });
            // } else {
            //     stack.push(Integer.parseInt(str));
            // }
        }
        return stack.peek();
    }
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"})); //22
        System.out.println(evalRPN(new String[] {"4","13","5","/","+"})); //6
    }
}