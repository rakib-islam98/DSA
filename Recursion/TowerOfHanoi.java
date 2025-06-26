import java.util.*;

public class TowerOfHanoi {
    static int count=0;
    public static void solve(int n,int s,int d,int h) {
        //Base
        if(n==1) {
            System.out.println("Move "+n+" disk from "+s+" to "+d);
            count++;
            return;
        }
        //Hypothesis
        solve(n-1,s,h,d);
        //Induction
        System.out.println("Move "+n+" disk from "+s+" to "+d);
        count++;
        solve(n-1,h,d,s);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        solve(n,1,3,2);
        System.out.println("Total Moves: "+count);

        sc.close();
    }
}