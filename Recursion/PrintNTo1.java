import java.util.Scanner;

public class PrintNTo1 {
    public static void printNto1(int n) {
        //base
        if(n==1)
        {
            System.out.print(1+" ");
            return;
        }
        //induction
        System.out.print(n+" ");
        //hypothesis
        printNto1(n-1);
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        printNto1(n);
        sc.close();
    }
}