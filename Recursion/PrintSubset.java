public class PrintSubset {
    public static void solve(String ip,StringBuilder op,int i) {
        //Base Condition: when i=ip length,we print op bcz we have used all character
        if(i==ip.length()) 
        {
            System.out.println(op);
            return;
        }
        //Two op for two decision of taking 1st character or not
        StringBuilder op1=new StringBuilder(op);
        StringBuilder op2=new StringBuilder(op);
        //In decision 2 we take 1st character
        op2.append(ip.charAt(i));   //op1: "", op2="a"

        //Now we take decision for the 2nd character for each decision
        solve(ip,op1,i+1);
        solve(ip,op2,i+1);
    }
    public static void main(String[] args) {
        String ip="abc";
        StringBuilder op=new StringBuilder("");
        solve(ip,op,0);
    }
}