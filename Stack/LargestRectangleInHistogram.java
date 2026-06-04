import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        //Consider each bar as minimum height and find max width
        for(int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i]; //0 to flash stack
            //pop and process from stack until currHeight < stack top
            while(!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int left = (stack.isEmpty()) ? -1 : stack.peek();
                int right = i;
                int area = h * (right - left - 1);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        return maxArea;
    }
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));   //10
        System.out.println(largestRectangleArea(new int[]{2,4}));   //4
    }
}