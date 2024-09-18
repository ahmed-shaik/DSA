public class New {

    public static String uncommonFromSentences(String s1, String s2) {
        String [] one = s1.split(" ");
        String [] two = s2.split(" ");
        String str = new String("");
        for(int i=0; i<one.length; i++) {
            if(!one[i].equals(two[i])) {
                str += one[i] + " ";
            }
        }
        for(int i=0; i<two.length; i++) {
            if(!two[i].equals(one[i])) {
                str += two[i] + " ";
            }
        }
        return str.trim();
    }
    public static void main(String[] args) {
        String s1 = "apple apple";
        String s2 = "banana";
        System.out.println(uncommonFromSentences(s1, s2));
    }
}