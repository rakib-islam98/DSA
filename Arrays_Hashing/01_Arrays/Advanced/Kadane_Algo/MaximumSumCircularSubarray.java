
public class MaximumSumCircularSubarray {
    public static int maxCircularSum(int arr[]) {
        // code here
        int n=arr.length;
        //Approach 1: Brute Force
        // int circularSum=arr[0];
        // for(int i=0;i<n;i++) {
        //     int currSum=0;
        //     for(int j=i;j<i+n;j++) {
        //         currSum+=arr[j%n];
        //         circularSum=Math.max(circularSum, currSum);
        //     }
        // }
        // return circularSum;


        //Approch 2: Better(prefix+maxSuffix)
        // int suffixSum=arr[n-1];
        // int[] maxSuffix=new int[n+1];
        // maxSuffix[n-1]=arr[n-1];
        
        // for(int i=n-2;i>=0;i--) {
        //     suffixSum=arr[i]+suffixSum;
        //     maxSuffix[i]=Math.max(suffixSum,maxSuffix[i+1]);
        // }
        // int prefixSum=0;
        // int currSum=0;
        
        // int circularSum=arr[0];
        // int normalSum=arr[0];
        
        // for(int i=0;i<n;i++) {
            
        //     //Kadanes's Algo
        //     currSum=Math.max(arr[i],currSum+arr[i]); //extend or fresh start
        //     normalSum=Math.max(normalSum,currSum); //straight max subarray sum
            
        //     //Circular Sum
        //     prefixSum+=arr[i];  //prefix sum till index i
        //     //prefixSum+suffixSum[i+1] for each prefixSum upto i added with maximum suffix 
        //     // after i
        //     circularSum=Math.max(circularSum,prefixSum + maxSuffix[i+1]);
        // }
        // return Math.max(normalSum,circularSum);


        //Approach 3: Total-Min Subarray
        int total=0;
        int maxSum=arr[0],currMax=0;
        int minSum=arr[0],currMin=0;

        for(int x:arr) {
            total+=x;

            currMax=Math.max(currMax+x,x);
            maxSum=Math.max(currMax,maxSum);

            currMin=Math.min(currMin+x,x);
            minSum=Math.min(currMin,minSum);
        }
        if(maxSum<0) return maxSum;
        return Math.max(maxSum,total-minSum);
    }
    public static void main(String[] args) {
        int[] arr = {8, -8, 9, -9, 10, -11, 12};
        System.out.println(maxCircularSum(arr));
    }
}