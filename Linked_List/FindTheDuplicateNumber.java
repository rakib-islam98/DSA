public class FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        // int n = nums.length;
        // Arrays.sort(nums);
        // for(int i = 1; i < n; i++) {
        //     if(nums[i] == nums[i-1]) {
        //         return nums[i];
        //     }
        // }
        // return -1;
        int slow = 0, first = 0;
        while(true) {
            slow = nums[slow];
            first = nums[nums[first]];
            if(slow == first) {
                break;
            }
        }
        int slow2 = 0;
        while(true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if(slow == slow2) return slow;
        }
    }
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{3,4,2,1,2}));
        // 0->3->1->4->2->
        //             |_|

    }
}