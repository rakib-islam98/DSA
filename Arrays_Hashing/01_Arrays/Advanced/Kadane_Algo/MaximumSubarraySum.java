import java.util.ArrayList;

public class MaximumSubarraySum {
    public static ArrayList<Integer> findMaxSubarraySum(int[] nums) {
        ArrayList<Integer> ans=new ArrayList<>();

        //code
        int maxL=0,maxR=0;
        int tempStart=0;
        int currSum=0,maxSum=nums[0];

        for(int i=0;i<nums.length;i++) {
            if(currSum+nums[i]<nums[i]) {
                currSum=nums[i];
                tempStart=i;
            }
            else currSum+=nums[i];
            if(currSum>maxSum) {
                maxSum=currSum;
                maxL=tempStart;
                maxR=i;
            }
        }
        System.out.println(maxSum);
        for (int idx = maxL; idx <= maxR; idx++) {
            ans.add(nums[idx]);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] test={3,5,-10,-2};
        System.out.println(findMaxSubarraySum(test));
    }
}