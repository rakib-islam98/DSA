public class PermutationWithSpaces {
    public static void solve(String ip,String op,int i) {
        if(i==ip.length())
        {
            System.out.println(op);
            return;
        }
        solve(ip,op+"_"+ip.charAt(i),i+1);
        solve(ip,op+ip.charAt(i),i+1);
    }
    public static void main(String[] args) {
        String ip="ABC";
        solve(ip,"A",1);
    }
}