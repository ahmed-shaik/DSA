package Java_Basics;
import java.util.Scanner;

public class JavaBasics {
    public static void main(String[] args) {
        // //Print function
        // System.out.println("Hello World");
        // System.out.print("Hello World\n");
        // System.out.print("Hello World\n");      

        // System.out.println("****");
        // System.out.println("***");
        // System.out.println("**");
        // System.out.println("*");

        // //variables
        // int a=10, b=15;
        // System.out.println(a+" "+b);

        // //data Types
        // byte c = 8;
        // char d = 's';
        // boolean e = true;
        // float f = 1.0f;
        // double dt = 11.5;
        // long l = 1123;

        // System.out.println(c+" "+ d+ " "+ e+""+ f+""+ dt+""+ l);
        // //input
        // Scanner sc = new Scanner(System.in);
        // String h = sc.next();
        // System.out.println(h);

        /*  
            next        => String
            nextLine    =>String (Full line)
            nextlnt     
            nextByte    
            nextFloat   
            nextDouble  
            nextBoolean 
            nextShort    
            nextLong    
        */
        
        //Operators
        /*
            Arithmetic Operators 
                Binary => +,*,/,%
                Unary => --,++
            Relational Operators => ==, !=, <, > , <=, >=
            Logical Operators => &&, ||, !
            Bitwise Operators => *, |, <<, >>
            Assignment Operators => =, +=, -=, *=, /=
         */

        //Conditional Statements
        /*
            if, else
            else if
            ternary operator
            switch 
        */
        // int age = 15;
        // if(age>=18) {
        //     System.out.println("adult");
        // } else if(age>=13) {
        //     System.out.println("Teenager");
        // } else {
        //     System.out.println("child");
        // }

        // //ternary operator
        // // variable = condition? statementl : statement2;

        // //Switch
        // int number = 2;
        // switch(number) {
        //     case 1: 
        //         System.out.println("samosa"); break;
        //     case 2:
        //         System.out.println("ice cream"); break;
        //     case 3:
        //         System.out.println("burger"); break;
        //     default:   
        //         System.out.println("wakey wakey");
        //}

        //Loops
        /*
            while, do-while, for
            break, continue, return
        */

        // int i = 0;
        // while(i<10) {
        //     System.out.println(i);
        //     i++;
        // }

        // Print number from 1 to n
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter a number: ");
        // int n = sc.nextInt(), i=1;
        // while (i<=n) {
        //     System.out.println(i);
        //     i++;
        // }

        // // for(initialization; condition; increment/decrement) {
        // //     statement
        // // }
        // for(int j=0; j<10; j++) {
        //     System.out.println(j);
        // }


        // //Arrays
        // // int[] arr = {1,2,3,4,5};
        // for(int num : arr) {
        //     System.out.println(num);
        // }

        //Print Reverse of a number
        int n=10899, rem, rev=0;
        while(n>0) {
            rem=n%10;
            rev = rev*10 + rem;
            n=n/10;
        }
        System.out.println(rev);

          
    }
}
