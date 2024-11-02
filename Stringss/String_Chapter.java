package Stringss;

// import java.util.Scanner;

public class String_Chapter {
    public static boolean checkPalindrome(String str) {
        for(int i=0; i<str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
    public static double shortestPath(String str) {
        int x=0,y=0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)=='N') {
                y++;
            } else if(str.charAt(i)=='S') {
                y--;
            } else if(str.charAt(i)=='E') {
                x++;
            } else if (str.charAt(i)=='W') {
                x--;
            }
        }
        return Math.sqrt(x*x + y*y);
    }
    public static String printLargest(String str[]) {
        String lar = str[0];
        for(int i=1; i<str.length; i++) {
            if(str[i-1].compareTo(str[i])<0) {
                lar = str[i-1];
            } 
        }
        return lar;
    }
    public static String convertToUppercase(String str) {
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));
        for(int i=1; i<str.length(); i++) {
            if(str.charAt(i-1) == ' ') {
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    public static String stringCompression(String str) {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < str.length(); i++) {
            Integer count=1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)) {
                count++;i++;
            }
            sb.append(str.charAt(i));
            if(count!=1) {
                sb.append(count.toString());
            }
        }
        return sb.toString();
    } 
    public static int pr_countLowerCase(String str) {
        int count=0;
            for(int i=0; i<str.length(); i++) {
                if(Character.isLowerCase(str.charAt(i))) {
                    count++;
                }
            }
        return count;
    }
    public static void main(String[] args) {
        // char arr[] = {'a', 'b', 'c', 'd'};
        // String str = "abcd";
        // String str2 = new String("xyz");     
        
        // // Strings are IMMUTABLE
        // Scanner sc = new Scanner(System.in);
        // sc. next();
        // String fullName = "Tony Stark";
        // System.out.println(fullName.length());
        // System.out.println(checkPalindrome("noon"));
        // System.out.println(shortestPath("WNEENESENNN"));
        // String fruits[] = {"apple", "mango", "banana"};
        // System.out.println(printLargest(fruits));
        // StringBuilder sb = new StringBuilder("");
        // for(char ch = 'a'; ch<='z'; ch++) {
        //     sb.append(ch);
        //     System.out.println(sb);
        // }
        // System.out.println(convertToUppercase("hi, i am Ahmed"));
        // System.out.println(stringCompression("abcd"));
        String str = "ApnaCollege";
        System.out.println(str.contains("ol"));
    }    
}
