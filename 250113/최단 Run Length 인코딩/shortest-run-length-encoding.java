import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.nextLine();  

        sc.close(); 

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < A.length(); ++i) {
            A = rightShift(A);
            answer = Math.min(answer, runLengthEnconding(A).length());
        }

        System.out.println(answer);
        return;
    }

    private static String rightShift(String s) {
        String result = "" + s.charAt(s.length()-1);
        result += s.substring(0, s.length()-1);
        return result;
    }

    private static String runLengthEnconding(String s) {
        int count = 1;
        char cmp = s.charAt(0);
        String result = "";

        for (int i = 1; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (cmp == c) {
                ++count;
            } else {
                result += cmp;
                result += count;
                count = 1;
                cmp = c;
            }
        }
        result += cmp;
        result += count;
        return result;
    }
}