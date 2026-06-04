import java.util.Arrays;

public class PivotIndex {
    public static int pivotIndex(int[] nums) {
        int n=nums.length;
        // int[] prefix=new int[n+1];
        // //int[] suffix=new int[n+1];

        // for(int i=0;i<n;i++) {
        //     prefix[i+1]=prefix[i]+nums[i];
        // }
        // // for(int i=n-1;i>=0;i--) {
        // //     suffix[i]=suffix[i+1]+nums[i];
        // // }
        // for(int i=0;i<n;i++) {
        //     // int prefixSum=prefix[i];
        //     // int suffixSum=suffix[i+1];
        //     // if(prefixSum==suffixSum) return i;
        //     int leftSum=prefix[i];
        //     int rightSum=prefix[n]-prefix[i+1];
        //     if(leftSum==rightSum) return i;
        // }
        int total=Arrays.stream(nums).sum();
        int leftSum=0;
        for(int i=0;i<n;i++) {
            int rightSum=total-leftSum-nums[i];
            if(leftSum==rightSum) return i;
            leftSum+=nums[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(pivotIndex(new int[]{1,2,3}));
        System.out.println(pivotIndex(new int[]{2,1,-1}));
        // 3 -1 0
    }
}