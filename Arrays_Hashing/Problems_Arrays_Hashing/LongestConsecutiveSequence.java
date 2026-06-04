import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<n;i++) {
            hs.add(nums[i]);
        }
        

        //Approach 1: Brute Force
        //for each ele check longest seq
        // int longest=0;
        // for(int num:nums) {
        //     //check strek for num
        //     int streak=0, curr=num;
        //     while(hs.contains(curr)) {
        //         curr++;
        //         streak++;
        //     }
        //     longest=Math.max(longest,streak);
        // }
        // return longest;

        //Approach 2: Sorting
        // Arrays.sort(nums);
        // int streak=1,longest=1;
        // //traverse the array
        // for(int i=1;i<n;i++) {
        //     //if gap same then skip
        //     if(nums[i]==nums[i-1]) continue;
        //     //if gap 1, increment streak
        //     else if(nums[i]==nums[i-1]+1) streak++;
        //     //gap more, reset streak, update longest
        //     else {
        //         longest=Math.max(longest,streak);
        //         streak=1;
        //     }
        // }
        // //update longest for the last ele
        // return Math.max(longest,streak);

        //Approach 3: Hashing O(n)
        int longest=0;
        for(int num:hs) {
            if(!hs.contains(num-1)) {
                int streak=0,curr=num;
                while(hs.contains(curr)) {
                    streak++;
                    curr++;   
                }
                longest=Math.max(longest,streak);
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        int[] nums=new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));

        nums=new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));

        nums=new int[]{1,0,1,2};
        System.out.println(longestConsecutive(nums));

        // 4 9 3
    }
}