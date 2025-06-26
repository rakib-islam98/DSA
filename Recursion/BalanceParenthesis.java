
import java.util.ArrayList;

public class BalanceParenthesis {
    public static void solve(int op,int cl,String res,ArrayList<String> ans) {
        //Base
        if(op==0 && cl==0) {
            ans.add(res);
            return;
        }

        if(op!=0) {
            solve(op-1,cl,res+"(",ans);
        }
        if(op<cl) {
            solve(op,cl-1,res+")",ans);
        }
    }

    public static ArrayList<String> getBalanceParenthesisList(int n) {
        ArrayList<String> ans=new ArrayList<>();
        int op=n,cl=n;
        String res="";
        solve(op,cl,res,ans);
        return ans;
    }

    public static void main(String[] args) {
        int n=3;
        ArrayList<String> ans=getBalanceParenthesisList(n);
        for (String str : ans) {
            System.out.println(str);
        }
    }
}
