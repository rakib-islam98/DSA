import java.util.*;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] arr) {
        //Approach 1: Brute Force
        // for(int i=0;i<arr.length;i++) {
        //     for(int j=i+1;j<arr.length;j++) {
        //         if(arr[i]==arr[j]) return true;
        //     }
        // }
        // return false;

        //Approach 2: Sorting
        /*
        - sort the array
        - check if any element appear twice
        */
        // Arrays.sort(arr);
        // for(int i=1;i<arr.length;i++) {
        //     if(arr[i]==arr[i-1]) return true;
        // }
        // return false;

        //Approach 3: HashSet
        // HashSet<Integer> hs=new HashSet<>();
        // for(int x:arr) {
        //     if(hs.contains(x)) return true;
        //     hs.add(x);
        // }
        // return false;

        //Approach4: length of distinct element or set length
        return Arrays.stream(arr).distinct().count()<arr.length;
    }
    
    public static void main(String[] args) {
        int[] nums={1,2,4,5,4};
        System.out.println(containsDuplicate(nums));
    }
}
