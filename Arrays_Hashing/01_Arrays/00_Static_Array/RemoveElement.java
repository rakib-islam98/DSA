import java.util.Arrays;

public class RemoveElement {
    public static int removeElement(int[] arr,int val) {
        // ArrayList<Integer> temp=new ArrayList<>();
        // for(int x:arr) {
        //     if(x!=val) temp.add(x);
        // }
        // for(int i=0;i<temp.size();i++) {
        //     arr[i]=temp.get(i);
        // }

        // return temp.size();
        int idx=-1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=val) {
                arr[idx+1]=arr[i];
                idx++;
            }
        }
        return idx+1;
    }

    public static void main(String[] args) {
        int[] arr={1,2,5,2,6,3,2,5};
        int val=3;

        System.out.println(Arrays.toString(arr));
        int newSize=removeElement(arr,val);

        for(int i=0;i<newSize;i++){
            System.out.print(arr[i]+" ");
        }
    }
}