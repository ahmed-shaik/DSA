package Stringss;

public class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
        int i = 1;
        StringBuilder sb = new StringBuilder(a);
        if (a.length() == b.length()) {
            if (a.equals(b)) {
                return 1;
            } else {
                if(sb.append(a).toString().contains(b)) {
                    return i+1;
                }
                return -1;
            }
        }
        while (sb.length() < b.length()) {
            sb.append(a);
            i++;
        }
        if (sb.toString().contains(b)) {
            return i;
        }
        sb.append(a);
        if (sb.toString().contains(b)) {
            return i + 1;
        }

        return -1;
    }    
}