public class LongestSubarrayWithSameValue {
    public static int findMaxLength(int[] arr) {
        // int temp=1;
        // int maxLen=1;
        // for(int i=1;i<arr.length;i++) {
        //     if(arr[i]==arr[i-1]) {
        //         temp++;
        //     }
        //     else {
        //         maxLen=Math.max(maxLen,temp);
        //         temp=1;
        //     }
        // }
        // //compairing for last window
        // maxLen=Math.max(maxLen,temp);

        //Sliding window version
        int maxLen=0,L=0;
        for(int R=0;R<arr.length;R++) {
            if(arr[L]!=arr[R]) L=R;
            maxLen=Math.max(maxLen, R-L+1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr={4,2,2,3,3,3};
        System.out.println(findMaxLength(arr));
    }
}