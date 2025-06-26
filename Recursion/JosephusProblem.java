
import java.util.ArrayList;

public class JosephusProblem {
    public static void solve(ArrayList<Integer> v,int k,int ind) {
        if(v.size()==1)
        {
            //return 1;   //just for return value
            return;
        }
        int pos=(ind+k)%v.size();
        //System.out.println(v.get(pos));
        v.remove(pos);
        //System.out.println("size: "+v.size());
        // System.out.println(v);

        solve(v,k,pos);

        // return v.get(0);
    }
    public static void main(String[] args) {
        int n=40,k=7;

        ArrayList<Integer> v=new ArrayList<>();
        for(int i=1;i<=n;i++) v.add(i);

        solve(v,k-1,0);
        System.out.println(v.get(0));
        //System.out.println(v.size());
    }
}