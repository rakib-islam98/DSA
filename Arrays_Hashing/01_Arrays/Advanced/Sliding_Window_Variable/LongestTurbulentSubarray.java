public class LongestTurbulentSubarray {
    public static int maxTurbulenceSize(int[] arr) {
        int len=1,maxLen=1;
        int prevComp=0,n=arr.length;

        for(int i=1;i<n;i++) {
            //sign of current pair
            int currComp=Integer.compare(arr[i-1],arr[i]);
            //if same ele, fresh start
            if(currComp==0) {
                len=1;
            } 
            //opposite direction,grow window
            else if(prevComp*currComp==-1) {
                len++;
            }
            //same direction,new pair
            else {
                len=2;
            }
            prevComp=currComp;
            maxLen=Math.max(maxLen,len);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr={9,4,2,10,7,8,8,1,9};
        System.out.println(maxTurbulenceSize(arr));

        int[] arr2={100};
        System.out.println(maxTurbulenceSize(arr2));
    }
}