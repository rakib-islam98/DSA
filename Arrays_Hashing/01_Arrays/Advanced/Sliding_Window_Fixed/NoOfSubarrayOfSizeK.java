public class NoOfSubarrayOfSizeK {
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int n=arr.length;
        int cnt=0;

        //Approach 1: O(nk)
        // for(int i=0;i+k-1<n;i++) {
        //     int sum=0;
        //     for(int j=i;j<i+k;j++) {
        //         sum+=arr[j];
        //     }
        //     if((sum/k)>=threshold) cnt++;
        // }

        //Approach 2: O(n)
        // int currSum=0;int L;
        // for(L=0;L<k-1;L++) {
        //     currSum+=arr[L];
        // }
        // while(L<n) {
        //     currSum+=arr[L];
        //     if((currSum/k)>=threshold) cnt++;
        //     currSum-=arr[L-k+1];
        //     L++;
        // }

        //Approach 3:Prefix Sum O(n)+O(n)
        // int[] prefixSum=new int[n+1];
        // /*
        // arr= [1,2,3]
        // prefixSum=[0,1,3,6] 
        //  */
        // for(int i=0;i<n;i++) {
        //     prefixSum[i+1]=prefixSum[i]+arr[i];
        // }
        // threshold*=k;
        // int l=0;
        // for(int r=k-1;r<n;r++) {
        //     int sum=prefixSum[r+1]-prefixSum[l];
        //     if(sum>=threshold) cnt++;
        //     l++;
        // }

        //Approach 4:
        threshold*=k;
        int currSum=0;

        for(int R=0;R<n;R++) {
            currSum+=arr[R];
            //From 1st occurance of window k, check for each ele 
            if(R>=k-1) {
                if(currSum>=threshold) cnt++;
                //exclude 1st element of window for next iteration
                currSum-=arr[R-k+1];
            }
        }

        return cnt;
    }
    public static void main(String[] args) {
        int[] nums=new int[]{2,2,2,2,5,5,5,8};
        int k=3,threshold=4;
        System.out.println(numOfSubarrays(nums, k,threshold));

        nums=new int[]{11,13,17,23,29,31,7,5,2,3};
        k=3;
        threshold=5;
        System.out.println(numOfSubarrays(nums, k,threshold));
    }
}