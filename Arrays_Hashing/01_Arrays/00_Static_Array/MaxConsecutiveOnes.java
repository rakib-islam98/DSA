public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
      int n=nums.length;
      //Brute force 
      /*
      - for each index i generate longest possible array 1
      - max of all such array is ans
       */
        // int max=0;
        // for(int i=0;i<n;i++) {
        //     int count=0;
        //     for(int j=i;j<n;j++) {
        //         if(nums[j]==0) break;
        //         count++;
        //     }
        //     max=Math.max(max,count);
        // }
        // return max;


        // one pass
        int count=0,max=0;
        for(int i=0;i<n;i++) {
            if(nums[i]==1) {
                count++;
                max=Math.max(count,max);
            }
            else   count=0;
        }
        return max;
    }
    
    public static void main(String[] args) {
        int[] arr={1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
}