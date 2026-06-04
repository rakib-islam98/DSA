public class MinSizeSubarraySum {
    public static int findLargestL(int[] prefix,int l,int h,int required) {
        int ans=-1;
        //Custom binary search
        while(l<=h) {
            int mid=l+(h-l)/2;
            if(prefix[mid]<=required) {
                ans=mid;    //one valid L
                l=mid+1;    //try to find larger L
            }
            else{
                h=mid-1;
            }
        }
        return ans;
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int minLen=n+1;

        //Brute Force: O(n^2)
        // for(int L=0;L<n;L++) {
        //     int currSum=0;
        //     for(int R=L;R<n;R++) {
        //         currSum+=nums[R];
        //         if(currSum>=target) {
        //             minLen=Math.min(minLen,R-L+1);
        //             break;
        //         }
        //     }
        // }

        //Using PrefixSum: O(nlogn)
        //build prefixsum
        int[] prefix=new int[n+1];
        for(int i=0;i<n;i++) {
            prefix[i+1]=prefix[i]+nums[i];
        }
        //iterate R, for each R find largest L which satisfy prefix[L]<=prefix[R+1]-target (from SubArraySum(L->R)>=target)
        for(int R=0;R<n;R++) {
            int required=prefix[R+1]-target;
            int L=findLargestL(prefix,0,R,required);
            if(L!=-1) {
                minLen=Math.min(minLen, R-L+1);
            }
        }

        //Sliding Window: O(n)
        // int L=0,currSum=0;
        // for(int R=0;R<n;R++) {
        //     currSum+=nums[R];
        //     while(currSum>=target) {
        //         minLen=Math.min(minLen,R-L+1);
        //         currSum-=nums[L];
        //         L++;
        //     }
        // }

        return (minLen==n+1)?0:minLen;
    }
    public static void main(String[] args) {
        int[] nums=new int[]{2,3,1,2,4,3};
        int target=7;
        System.out.println(minSubArrayLen(target,nums));

        nums=new int[]{1,1,1,1,1,1,1,1};
        target=11;
        System.out.println(minSubArrayLen(target,nums));
    }
}