import java.util.*;
public class KthSymbolGrammar {
    public static int solve(int N,int K) {
        if(N==1 && K==1)
            return 0;
        int mid=(int)Math.pow(2,N-1)/2;

        if(K<=mid) return solve(N-1,K);
        else return 1-solve(N-1,K-mid);
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter N: ");
        int N=sc.nextInt();
        System.out.print("Enter K: ");
        int K=sc.nextInt();
        sc.close();
        
        System.out.println(solve(N,K));
    }
}