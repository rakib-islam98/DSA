import java.util.Arrays;
import java.util.Stack;

public class DailyTempretures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        // for(int i = 0; i < n; i++) {
        //     int curr_temp = temperatures[i];
        //     for(int j = i+1; j < n; j++) {
        //         int future_temp = temperatures[j];
        //         if(future_temp > curr_temp) {
        //             ans[i] = j - i;
        //             break;
        //         }
        //     }
        // }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            //resolve element in the stack when we find a warmer day
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevInd = stack.pop();
                ans[prevInd] = i - prevInd;
            }
            stack.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
        // [1, 1, 4, 2, 1, 1, 0, 0]
        System.out.println(Arrays.toString((dailyTemperatures(new int[]{30,40,50,60}))));
        // [1, 1, 1, 0]
    }
}