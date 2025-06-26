// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class SortUsingRecursion {
    
    public static int[] insert(int[] arr,int val) {
        //insert using recursion
        //Base
        int n=arr.length;
        if(n==0)
        {
            return new int[]{val};
        }
        if(arr[n-1]<=val)
        {
            int[] temp=new int[n+1];
            System.arraycopy(arr, 0, temp, 0, n);
            temp[n]=val;
            return temp;
        }
        //Hypothesis
        int ele=arr[n-1];
        int[] reduced=Arrays.copyOf(arr,n-1);
        reduced=insert(reduced,val);
        //Induction
        int m=reduced.length;
        int[] original=new int[m+1];
        System.arraycopy(reduced, 0, original, 0, m);
        original[m]=ele;
        return original;
        //Insert using loop
        // int n=arr.length;
        // int[] temp=new int[n+1];
        
        // int i=0,j=0;
        // while(i<n) 
        // {
        //     if(arr[i]<val)
        //     {
        //         temp[j]=arr[i];
        //         i++;j++;
        //     }
        //     else
        //     {
        //         temp[j]=val;
        //         j++;
        //         break;
        //     }
        // }
        // while(i<n && j<temp.length)
        // {
        //     temp[j]=arr[i];
        //     i++;j++;
        // }
        // if(i==n && j!=temp.length)
        //     temp[temp.length-1]=val;
        // return temp;
    }
    public static int[] sort(int [] arr) {
        //Base
        int n=arr.length;
        if(arr.length==1) return arr;
        //Hypothesis
        int ele=arr[n-1];
        int[] reduced=Arrays.copyOf(arr,n-1);
        reduced=sort(reduced);
        //Induction
        return insert(reduced,ele);
    }
    public static void main(String[] args) {
        int arr[]={5,4,3,0,-1,7};
        arr=sort(arr);
        for (int x : arr)
            System.out.print(x+" ");
    }
}