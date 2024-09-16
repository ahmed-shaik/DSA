public class New {

    public static void main(String[] args) {
        String str[] = {"01:01","02:01","03:00"};
        int one = Integer.parseInt(str[0].split(":")[0]);
        System.out.println(one);
    }
    
}