import java.util.HashMap;

public class ContainsDuplicate2 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int n=nums.length;
        //Approach 1: O(nk),O(1)
        // for(int L=0;L<n;L++) {
        //     for(int R=L+1;R<=Math.min(L+k,n-1);R++) {
        //         if(nums[L]==nums[R])
        //             return true;
        //     }
        // }
        // return false;

        //Approach 2: Map 
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++) {
            if(hm.containsKey(nums[i]) && i-hm.get(nums[i])<=k) return true;
            
            hm.put(nums[i],i);
        }
        return false;
        //Approach 3: O(n), O(n)
        // HashSet<Integer> hs=new HashSet<>();
        // int L=0;
        // for(int R=0;R<n;R++) {
        //     if(R-L>k) {
        //         hs.remove(nums[L]);
        //         L++;
        //     }
        //     if(hs.contains(nums[R])) return true;
        //     hs.add(nums[R]);
        // }
        // return false;
    }
    public static void main(String[] args) {
        int[] nums=new int[]{1,0,1,1};
        int k=1;
        System.out.println(containsNearbyDuplicate(nums, k));

        nums=new int[]{1,2,3,1,2,3};
        k=2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}