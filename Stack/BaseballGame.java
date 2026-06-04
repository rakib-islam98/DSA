import java.util.Stack;

class BaseballGame {
    public static int calPoints(String[] operations) {
        Stack<Integer> stk = new Stack<>();
        int sum = 0;

        for(String str : operations) {
            //if C, invalidate 1
            if(str.equals("C")) {
                sum -= stk.pop();
            } else if(str.equals("D")) {
                int val = stk.peek();
                stk.push(val*2);
                sum += val*2;
            } else if(str.equals("+")) {
                int a = stk.pop();
                int b = stk.peek();
                stk.push(a);
                stk.push(a + b);
                sum += (a+b);
            }else {
                //push the number to stake
                int num = Integer.parseInt(str);
                stk.push(num);
                sum += num;
            }
        }
        // int sum = 0;
        // while(!stk.isEmpty()) {
        //     sum += stk.pop();
        // }
        // return sum;

        return sum;
    }
    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
        System.out.println(calPoints(new String[]{"1","C"}));

        // 30 27 0
    }
}