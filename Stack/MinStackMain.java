import java.util.Stack;

class MinStack {
    Stack<Long> stack;
    long min;
    //Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        //minStack = new Stack<>();
    }
    
    public void push(int val) {
        // if(minStack.isEmpty() || val <= minStack.peek()) minStack.push(val);
        // else {
        //     Stack<Integer> temp = new Stack<>();
        //     while(!minStack.isEmpty() && val > minStack.peek()) {
        //         temp.add(minStack.pop());
        //     }
        //     minStack.push(val);
        //     while(!temp.isEmpty()) minStack.push(temp.pop());
        // }


        // stack.push(val);
        // if(minStack.isEmpty() || val <= minStack.peek()) minStack.push(val);


        if(stack.isEmpty()) {
            //stack empty-> min=val, diff=0
            stack.push(0l);
            min = (long)val;
        }
        //else push diff = val - min
        else {
            long diff = (long)val - min;
            stack.push(diff);
            if (diff < 0) min = val;
        }
    }
    
    public void pop() {
        // int val = stack.pop();
        // // Stack<Integer> temp = new Stack<>();
        // // while(minStack.peek() != val) {
        // //     temp.add(minStack.pop());
        // // }
        // // minStack.pop(); //remove val
        // // while(!temp.isEmpty()) minStack.push(temp.pop());
        // if(val == minStack.peek()) minStack.pop();

        long diff = stack.pop(); //diff was = val(currMin) - min(old)
        //if top() < 0 -> popping changes currMin
        if(diff < 0) {
            //store prev min: old_min = min - diff
            min = min - diff;
        }
    }
    
    public int top() {
        // return stack.peek();

        //if top <= 0, then min is top else (min + diff) is top
        long diff = stack.peek();
        return (diff < 0) ? (int)min : (int)(diff + min);
    }
    
    public int getMin() {
        // return minStack.peek();
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

public class MinStackMain {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin());  // return -2
    }
}