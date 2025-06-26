import java.util.*;
public class Print1ToN {
    public static void print1toN(int n)
    {
        //Base
        if(n==1)
        {
            System.out.print(n+" ");
            return;
        }
        //Hypothesis
        print1toN(n-1);
        //Induction
        System.out.print(n+" ");
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n=sc.nextInt();
            print1toN(n);
        }
    }
}
