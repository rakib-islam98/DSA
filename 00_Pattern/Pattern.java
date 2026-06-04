import java.util.Scanner;

public class Pattern {

    public static void main(String[] args) {
        System.out.print("Enter n: ");
        int n;
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
        }
        System.out.println("\nPattern 1");
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        System.out.println("\nPattern 2");
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        System.out.println("\nPattern 3");
        for(int i=1;i<=n;i++) {
            int cnt=1;
            for(int j=1;j<=i;j++) {
                System.out.print(cnt++ + " ");
            }
            System.out.println();
        }
        
        System.out.println("\nPattern 4");
        int cnt=1;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                System.out.print(cnt + " ");
            }
            cnt++;
            System.out.println();
        }
        
        System.out.println("\nPattern 5");
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n-i+1;j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        System.out.println("\nPattern 6");
        for(int i=1;i<=n;i++) {
            cnt=1;
            for(int j=1;j<=n-i+1;j++) {
                System.out.print(cnt++ + " ");
            }
            System.out.println();
        }
        
        System.out.println("\nPattern 7");
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n-i;j++) {
                System.out.print("  ");
            }
            for(int j=1;j<=2*i-1;j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        System.out.println("\nPattern 8");
        for(int i=n;i>=1;i--) {
            for(int j=1;j<=n-i;j++) {
                System.out.print("  ");
                
            }
            for(int j=1;j<=2*i-1;j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        System.out.println("\nPattern 9");
        // for(int i=1;i<=n;i++) {
        //     for(int j=1;j<=n-i;j++) {
        //         System.out.print("  ");
        //     }
        //     for(int j=1;j<=2*i-1;j++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }
        // for(int i=n;i>=1;i--) {
        //     for(int j=1;j<=n-i;j++) {
        //         System.out.print("  ");
                
        //     }
        //     for(int j=1;j<=2*i-1;j++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }
        //Trying it in one outer loop
         for(int i=1;i<=2*n;i++) {
            int k=(i>n)?2*n+1-i:i;
            for(int j=1;j<=n-k;j++) {
                System.out.print("  ");
            }
            for(int j=1;j<=2*k-1;j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        System.out.println("\nPattern 10");
        for(int i=1;i<2*n;i++) {
            int star=(i>n)?2*n-i:i;
            for(int j=1;j<=star;j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        System.out.println("\nPattern 11");
        int bit=0;
        for(int i=1;i<=n;i++) {
            if(i%2!=0) bit=1-bit;
            for(int j=1;j<=i;j++) {
                System.out.print(bit+" ");
                bit=1-bit;
            }
            System.out.println();
        }
        
        System.out.println("\nPattern 12");
        for(int i=1;i<=n;i++) {
            cnt=1;
            for(int j=1;j<=i;j++) {
                System.out.print(cnt++ +" ");
            }
            for(int j=1;j<=2*(n-i);j++) {
                System.out.print("  ");
            }
            cnt--;
            for(int j=1;j<=i;j++) {
                System.out.print(cnt-- +" ");
            }
            System.out.println();
        }
        
        System.out.println("\nPattern 13");
        cnt=1;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                System.out.print(cnt++ +" ");
            }
            System.out.println();
        }

        System.out.println("\nPattern 14");
        for(int i=1;i<=n;i++) {
            char ch='A';
            for(int j=1;j<=i;j++) {
                System.out.print(ch++ + " ");
            }
            System.out.println();
        }

        System.out.println("\nPattern 15");
        for(int i=n;i>=1;i--) {
            char ch='A';
            for(int j=1;j<=i;j++) {
                System.out.print(ch++ + " ");
            }
            System.out.println();
        }

        System.out.println("\nPattern 16");
        char ch='A';
        for(int i=n;i>=1;i--) {
            for(int j=1;j<=i;j++) {
                System.out.print(ch + " ");
            }
            ch++;
            System.out.println();
        }

        System.out.println("\nPattern 17");
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n-i;j++) {
                System.out.print("  ");
            }
            ch='A';
            for(int j=1;j<=i;j++) {
                System.out.print(ch++ + " ");
            }
            ch-=2;
            for(int j=1;j<=i-1;j++) {
                System.out.print(ch-- + " ");
            }
            System.out.println();
        }

        System.out.println("\nPattern 18");
        for(int i=1;i<=n;i++) {
            ch=(char)(65+(n-i));
            for(int j=1;j<=i;j++) {
                System.out.print(ch++ + " ");
            }
            System.out.println();
        }

        System.out.println("\nPattern 19");
        for(int i=1;i<=2*n;i++) {
            int k=(i>n)?(2*n-i+1):i;
            for(int j=1;j<=(n+1)-k;j++) {
                System.out.print("* ");
            }
            for(int j=1;j<=2*k-2;j++) {
                System.out.print("  ");
            }
            for(int j=1;j<=(n+1)-k;j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("\nPattern 20");
        for(int i=1;i<=2*n;i++) {
            int k=(i>n)?(2*n-i):i;
            for(int j=1;j<=k;j++) {
                System.out.print("* ");
            }
            for(int j=1;j<=2*n-2*k;j++) {
                System.out.print("  ");
            }
            for(int j=1;j<=k;j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("\nPattern 21");
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(i==1 || i==n || j==1 || j==n) {
                    System.out.print("*");
                }
                else System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println("\nPattern 22");
        for(int i=1;i<=2*n-1;i++) {
            for(int j=1;j<=2*n-1;j++) {
                int val=1+Math.max(Math.abs(n-i),Math.abs(n-j));
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
}