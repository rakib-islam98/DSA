import java.util.HashMap;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] arr, int k) {
        int n=arr.length;
        int sum=0;int count=0;
        HashMap <Integer,Integer> prefixSum=new HashMap<>();
        //Initially 0 occurs 1 before array
        prefixSum.put(0,1);
        //Iterate over the array
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
            int rem=sum-k;
            if(prefixSum.containsKey(rem))
                count+=prefixSum.get(rem);
            prefixSum.put(sum,prefixSum.getOrDefault(sum,0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,2,3}, 3));
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
    }
}