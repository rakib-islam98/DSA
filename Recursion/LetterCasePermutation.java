public class LetterCasePermutation {
    public static void solve(String ip,String op,int i) {
        if(i==ip.length())
        {
            System.out.println(op);
            return;
        }
        if(Character.isDigit(ip.charAt(i))) 
        {
            solve(ip,op+ip.charAt(i),i+1);
        }
        else
        {
            solve(ip,op+Character.toLowerCase(ip.charAt(i)),i+1);
            solve(ip,op+Character.toUpperCase(ip.charAt(i)),i+1);
        }
    }
    public static void main(String[] args) {
        String ip="A1b2";
        solve(ip,"",0);
    }
}