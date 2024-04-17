import java.util.Scanner;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        IntStream.range(0, b).forEach(i -> System.out.println("*".repeat(a)));
    }
}