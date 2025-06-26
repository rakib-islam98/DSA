import java.util.ArrayList;

public class PrintAllNdigitBinary {
    //Print all n digit binary with no of 1's>=0's in all it's prefixes 
    public static void solve(int zero,int one,String res,ArrayList<String> ans,int n) {
        if(n==0)
        {
            ans.add(res);
            return;
        }
        solve(zero,one+1,res+"1",ans,n-1);
        if(one>zero)
        {
            solve(zero+1,one,res+"0",ans,n-1);
        }
    }
    public static ArrayList<String> getAllBinaryStrings(int n) {
        ArrayList<String> ans=new ArrayList<>();
        int zero=n,one=n;
        String res="";
        solve(zero,one,res,ans,n);
        return ans;
    }
    public static void main(String[] args) {
        int n=4;
        ArrayList<String> ans=getAllBinaryStrings(n);
        for (String str : ans) {
            System.out.println(str);
        }
    }
}