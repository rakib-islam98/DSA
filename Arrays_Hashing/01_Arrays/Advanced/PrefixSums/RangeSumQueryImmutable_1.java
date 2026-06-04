class NumArray {
    int[] prefixSum;
    public NumArray(int[] nums) {
        int n=nums.length;
        prefixSum=new int[n+1];
        // arr=-2,0,3,-5,2,-11
        //prefixSum=0,-2,-2,1,-4,-2,-13
        for(int i=0;i<n;i++) {
            prefixSum[i+1]=prefixSum[i]+nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return (prefixSum[right+1]-prefixSum[left]);
    }
}
public class RangeSumQueryImmutable_1 {
    public static void main(String[] args) {
        int[] arr={-2, 0, 3, -5, 2, -1};
        NumArray test=new NumArray(arr);
        System.out.println(test.sumRange(0, 2));
        System.out.println(test.sumRange(0, 5));
    }
}