import java.util.*;

public class Main {
    static int Answer = Integer.MIN_VALUE;
    static char[] Arr;
    static int[] Nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String expression = sc.nextLine();
        Arr = new char[expression.length()];

        int i = 0, count = 0;
        for (char c : expression.toCharArray()) {
            if (Character.isLetter(c)) {
                ++count;
            }
            Arr[i++] = c;
        }

        Nums = new int[count];

        dfs(0);

        System.out.println(Answer);
    }

    private static void dfs(int size) {
        if (size == Nums.length) {
            Answer = Math.max(Answer, calculate());
            return;
        }

        for (int i = 1; i <= 4; ++i) {
            Nums[size] = i;
            dfs(size+1);
            Nums[size] = 0;
        }
    }

    private static int calculate() {
        int result = Nums[0], numIndex = 1;

        for (int i = 1; i < Arr.length; i += 2) {
            if (Arr[i] == '+') {
                result += Nums[numIndex++];
            } else if (Arr[i] == '-') {
                result -= Nums[numIndex++];
            } else if (Arr[i] == '*') {
                result *= Nums[numIndex++];
            }
        }

        return result;
    }
}