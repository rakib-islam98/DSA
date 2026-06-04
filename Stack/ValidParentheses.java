import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(char ch : s.toCharArray()) {
            // if(ch == '(' || ch == '{' || ch == '[') {
            //     stk.push(ch);
            // } 
            // else if((ch == ')' || ch == '}' || ch == ']') && stk.isEmpty()) return false;
            // else if(ch == ')' && stk.peek() == '(') stk.pop();
            // else if(ch == '}' && stk.peek() == '{') stk.pop();
            // else if(ch == ']' && stk.peek() == '[') stk.pop();
            // else return false;
            if(ch == '(') stk.push(')');
            else if(ch == '{') stk.push('}');
            else if(ch == '[') stk.push(']');
            else if(stk.isEmpty() || ch != stk.pop()) return false;
        }
        return stk.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([])"));
        System.out.println(isValid("([)]"));

        /*
        true
        false
        true
        false
        */
    }
}