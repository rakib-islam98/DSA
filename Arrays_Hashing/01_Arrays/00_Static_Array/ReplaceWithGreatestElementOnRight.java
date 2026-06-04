import java.util.Arrays;

public class ReplaceWithGreatestElementOnRight {
    public static int[] replaceElements(int[] arr) {
        int n=arr.length;
        //Brute Force
        // for(int i=0;i<n;i++) {
        //     int rightMax=-1;
        //     for(int j=i+1;j<n;j++) {
        //         rightMax=Math.max(rightMax,arr[j]);
        //     }
        //     arr[i]=rightMax;
        // }

        //optimal
        int rightMax=-1;

        for(int i=n-1;i>=0;i--) {
            int current=arr[i];
            arr[i]=rightMax;
            rightMax=Math.max(rightMax,current);
        }
        return arr;


        // if(n==1) {
        //     arr[n-1]=-1;
        //     return arr;
        // }
        // if(n==2) {
        //     arr[n-2]=arr[n-1];
        //     arr[n-1]=-1;
        //     return arr;
        // }  
        // int prev=arr[n-2];
        // arr[n-2]=arr[n-1];
        // arr[n-1]=-1;
        // for(int i=n-3;i>=0;i--) {
        //     //find max
        //     int max=Math.max(prev,arr[i+1]);
        //     //store curr
        //     prev=arr[i];
        //     arr[i]=max;
        // }
        // return arr;
    }
    
    public static void main(String[] args) {
        int[] arr={17,18,5,4,6,1};
        System.out.println(Arrays.toString(replaceElements(arr)));
    }
}