import java.util.HashSet;

public class PrintUniqueSubset {
    public static void solve(String ip,String op,HashSet<String> hs,int i) {
        //Base Condition: when i=ip length,we print op bcz we have used all character
        if(i==ip.length()) 
        {
            hs.add(op);
            return;
        }
        solve(ip,op,hs,i+1);
        solve(ip,op+ip.charAt(i),hs,i+1);
    }
    public static void main(String[] args) {
        String ip="aab";
        HashSet<String> hs=new HashSet<>();
        solve(ip,"",hs,0);
        System.out.println(hs);
    }
}