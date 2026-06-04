import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        //brute Force
        // HashSet<List<Integer>> hs=new HashSet<>();
        // for(int i=0; i<n; i++) {
        //     for(int j=i+1; j<n; j++) {
        //         for(int k=j+1; k<n; k++) {
        //             if(nums[i] + nums[j] + nums[k] == 0) {
        //                 List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
        //                 Collections.sort(triplet);
        //                 hs.add(triplet); 
        //             }
        //         }
        //     }
        // }
        // return new ArrayList<>(hs);

        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i = 0; i < n; i++) {
            //if a>0 after sorting, no soln
            if(nums[i] > 0) break;
            //if duplicate a value, skip
            if(i > 0 && nums[i] == nums[i-1]) continue;
            //apply two pointer
            int l = i + 1, r = n - 1;
            while(l < r) {
                int tripletSum = nums[i] + nums[l] + nums[r];
                if(tripletSum > 0) r--;
                else if(tripletSum < 0) l++;
                else {  //tripletSum==0..1 valid triplet
                ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                l++;
                r--;
                //chcek for duplicate for l
                while(l < r && nums[l] == nums[l-1]) l++;
                //chcek for duplicate for r(optional)
                while(l < r && nums[r] == nums[r+1]) r--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}