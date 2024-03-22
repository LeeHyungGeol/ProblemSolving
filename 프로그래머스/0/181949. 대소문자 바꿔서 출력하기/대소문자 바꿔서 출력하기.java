import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String answer = "";
        
        for (int i = 0; i < a.length(); ++i) {
            char tmp = a.charAt(i);
            if(Character.isUpperCase(tmp)) answer += Character.toLowerCase(tmp);
            else if (Character.isLowerCase(tmp)) answer += Character.toUpperCase(tmp);
        }
        
        System.out.println(answer);
    }
}