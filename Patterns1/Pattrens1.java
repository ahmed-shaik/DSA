package Patterns1;

public class Pattrens1 {
    public static void main(String[] args) {
        /*

         * 
         * *
         * * *
         * * * *
         * * * * *
         
         */
        // for(int i=1; i<=8; i++) {
        //     for(int j=1; j<=i; j++) {
        //         System.out.print("* ");
        //     }   
        //     System.out.println();
        // }

        /*
        Print INVERTED-STAR pattern
        
        ******
        *****
        ***
        ***
        **
        *

         */
        // for(int i=8; i>=1; i--) {
        //     for(int j=1; j<=i; j++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        /*
        Print HALF-PYRAMID pattern
        1
        12
        123
        1234
         */
        // for(int i=1; i<=5; i++) {
        //     for (int j=1; j<=i; j++) {
        //         System.out.print(j+" ");
        //     }
        //     System.out.println();
        // }

        /*
        Print CHARACTER pattern
        A
        BC
        DEF
        GHIJ
         */
        char ch='A';
        for(int i=1; i<=10; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print(ch+ " ");
                ch++;
            }
            System.out.println();
        }
    }
}
