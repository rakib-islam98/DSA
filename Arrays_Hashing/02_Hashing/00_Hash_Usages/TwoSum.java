import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        
        //brute force 
        /*
        - try out all the pairs and return the result
        */
        
        // for(int i=0;i<n;i++) {
        //     for(int j=i+1;j<n;j++) {
        //         if(nums[i]+nums[j]==target) {
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // return new int[]{-1,-1};

        //Approach 2: Sorting + Binary Search
        // int[][] arrMap=new int[n][2];
        // for(int i=0;i<n;i++) {
        //     arrMap[i][0]=i;
        //     arrMap[i][1]=nums[i];
        // }
        // Arrays.sort(arrMap,(a,b)->Integer.compare(a[1],b[1]));
        // int j=-1;
        // for(int i=0;i<n;i++) {
        //     int complement=target-arrMap[i][1];
        //     j=binarySearch(arrMap,i+1,n-1,complement);
        //     if(j!=-1) {
        //         return new int[]{arrMap[i][0],arrMap[j][0]};
        //     }
        // }
        // return new int[]{-1,-1};

        //Approach 3: Sorting + two pointer
        // int[][] arrMap=new int[n][2];
        // for(int i=0;i<n;i++) {
        //     arrMap[i][0]=i;
        //     arrMap[i][1]=nums[i];
        // }
        // Arrays.sort(arrMap,(a,b)->Integer.compare(a[1],b[1]));
        
        // int left=0,right=n-1;
        // while(left<right) {
        //     int sum=arrMap[left][1]+arrMap[right][1];
        //     if(sum==target) return new int[]{arrMap[left][0],arrMap[right][0]};
        //     else if(sum<target) left++;
        //     else right--;
        // }
        // return new int[]{-1,-1};

        //Optimal: Hashing
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++) {
            int complement=target-nums[i];
            if(hm.containsKey(complement)) {
                return new int[]{hm.get(complement),i};
            }
            hm.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

    public static int binarySearch(int[][] arr,int low,int high,int key) {
        while(low<=high) {
            int mid=low+(high-low)/2;
            if(arr[mid][1]==key) return mid;
            else if (arr[mid][1]<key) low=mid+1;
            else high=mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int target=9;
        int[] ans=twoSum(nums,target);
        System.out.print(Arrays.toString(ans));
    }
}