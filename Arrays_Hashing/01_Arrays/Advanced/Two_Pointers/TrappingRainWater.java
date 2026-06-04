public class TrappingRainWater {
    public static int trap(int[] height) {
        int n=height.length;

        //Approach 1: Prefix
        // int[] leftMax=new int[n];
        // int[] rightMax=new int[n];

        // leftMax[0]=height[0];
        // for(int i=1;i<n;i++) {
        //     leftMax[i]=Math.max(leftMax[i-1],height[i]);
        // }

        // rightMax[n-1]=height[n-1];
        // for(int i=n-2;i>=0;i--) {
        //     rightMax[i]=Math.max(rightMax[i+1],height[i]);
        // }

        // int water=0;
        // for(int i=0;i<n;i++) {
        //     water+= Math.min(leftMax[i],rightMax[i])-height[i];
        // }
        // return water;

        //Approach 2: Monotonic Stack
        // Stack<Integer> stk=new Stack<>();
        // int water=0;
        // for(int right=0;right<n;right++) {
        //     while(!stk.isEmpty() && height[right]>height[stk.peek()]) {
        //         int bottom=stk.pop();
        //         if(stk.isEmpty()) break;
        //         int left=stk.peek();

        //         int h=Math.min(height[left],height[right])-height[bottom];
        //         int w=right-left-1;
        //         water+= h*w;
        //     }
        //     stk.push(right);
        // }
        // return water;


        //Approach 3: Two pointer
        int L=0,R=n-1;
        int maxL=0,maxR=0;
        int water=0;

        while(L<R) {
            maxL=Math.max(maxL,height[L]);
            maxR=Math.max(maxR,height[R]);
            if(height[L]<height[R]) {
                water+= maxL-height[L];
                L++;
            } else {
                water+= maxR-height[R];
                R--;
            }
        }
        return water;
    }
    public static void main(String[] args) {
        int[] height=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
        height=new int[]{4,2,0,3,2,5};
        System.out.println(trap(height));
    }
}