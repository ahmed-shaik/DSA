package Patterns2;

public class patterns {
    public static void main(String[] args) {
        /*
        * * * * *
        *       *
        *       *
        * * * * *
        */
        // for(int i=1; i<=5; i++) {
        //     for(int j=1; j<=5; j++) {
        //         if(i==1 || i==5 || j==1 || j==5) {
        //             System.out.print("* ");
        //         } else {
        //             System.out.print("  ");
        //         }
        //     }
        //     System.out.println();
        // }

        /*
                *
               **
              ***
             ****
            *****  
        */
        // for(int i=1; i<=10; i++) {
        //     for(int j=1; j<=10-i; j++) {
        //         System.out.print(" ");
        //     }
        //     for(int j=1; j<=i; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        /*
            1 2 3 4 5
            1 2 3 4
            1 2 3 
            1 2 
            1 
        */
        // for(int i=1; i<=5; i++) {
        //     for(int j=1; j<=5-i+1; j++) {
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }
        /*
            1 
            2 3
            4 5 6 
            7 8 9 10
            11 12 13 14 15 
        */
        // int c=1;
        // for(int i=1; i<=5; i++) {
        //     for(int j=1; j<=i; j++) {
        //         System.out.printf("%3d", c++);
        //     }
        //     System.out.println();
        // }

        /*
            1
            0 1
            1 0 1
            0 1 0 1
            1 0 1 0 1 
        */
        // for(int i=1; i<=5; i++) {
        //     for(int j=1; j<=i; j++) {
        //         if((i+j)%2==0) {
        //             System.out.print(1+" ");
        //         } else {
        //             System.out.print(0+ " ");
        //         }
        //     }
        //     System.out.println();
        // }
        /*
            *             *
            * *         * *
            * * *     * * *
            * * * * * * * *
            * * * * * * * *
            * * *     * * *
            * *         * *
            *             *
        */
        // int n=10;
        // for(int i=1; i<=n; i++) {
        //     for(int j=1; j<=i; j++) {
        //         System.out.print("* ");
        //     }
        //     for(int j=1; j<=2*(n-i); j++) {
        //         System.out.print("  ");
        //     }
        //     for(int j=1; j<=i; j++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }
        // for(int i=n; i>=1; i--) {
        //     for(int j=1; j<=i; j++) {
        //         System.out.print("* ");
        //     }
        //     for(int j=1; j<=2*(n-i); j++) {
        //         System.out.print("  ");
        //     }
        //     for(int j=1; j<=i; j++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        /*
                *****
               *****
              *****
             *****
            *****
        // */
        // for(int i=1; i<=5; i++) {
        //     for(int j=1; j<=5-i; j++) {
        //         System.out.print("  ");
        //     }
        //     for(int j=1; j<=5; j++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        /*
                *****
               *   *
              *   *
             *   *
            *****
        */
        // for(int i=1; i<=5; i++) {
        //     for(int j=1; j<=5-i; j++) {
        //         System.out.print("  ");
        //     }
        //     for(int j=1; j<=5; j++) {
        //         if(i==1 || i==5 || j==1 || j==5) {
        //             System.out.print("* ");
        //         } else {
        //             System.out.print("  ");
        //         }
        //     }
        //     System.out.println();
        // }

        /*
               *
              ***
             *****
            *******
            *******
             *****
              ***
               *
        */
        int n=8;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }
            for(int j=1; j<=(2*i)-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n; i>=1; i--) {
            for(int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }
            for(int j=1; j<=(2*i)-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
