public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maxArea=0,n=height.length;

        //Brute Force
        // for(int i=0;i<n;i++) {
        //     for(int j=i+1;j<n;j++) {
        //         int currArea=Math.min(height[j],height[i])*(j-i);
        //         maxArea=Math.max(maxArea,currArea);
        //     }
        // }

        //Two Pointer
        int L=0,R=n-1;
        while(L<R) {
            int currArea=Math.min(height[L],height[R])*(R-L);
            maxArea=Math.max(maxArea,currArea);
            if(height[L]<height[R]) L++;
            else R--;
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}