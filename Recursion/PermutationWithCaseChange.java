public class PermutationWithCaseChange {
    public static void solve(String ip,String op,int i) {
        if(i==ip.length())
        {
            System.out.println(op);
            return;
        }
        solve(ip,op+Character.toLowerCase(ip.charAt(i)),i+1);
        solve(ip,op+Character.toUpperCase(ip.charAt(i)),i+1);
    }
    public static void main(String[] args) {
        String ip="Ab";
        solve(ip,"",0);
    }
}