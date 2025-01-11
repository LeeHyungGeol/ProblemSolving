import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] left = new int[n];
        int[] right = new int[n];
        int[] down = new int[n];

        for (int i = 0; i < n; i++) {
            left[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            right[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            down[i] = sc.nextInt();
        }
    
        sc.close();
        
        rotate(left, right, down, n, t);

        for (int i = 0; i < n; ++i) {
            System.out.print(left[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < n; ++i) {
            System.out.print(right[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < n; ++i) {
            System.out.print(down[i]+" ");
        }
        System.out.println();

    }

    private static void rotate(int[] left, int[] right, int[] down, int n, int t) {
        for (int count = 0; count < t; ++count) {
            int leftTop = left[n-1];
            int rightBottom = right[n-1];
            int bottom = down[n-1];

            for (int i = n-1; i >= 1; --i) {
                left[i] = left[i-1];
            }
            for (int i = n-1; i >= 1; --i) {
                right[i] = right[i-1];
            }
            for (int i = n-1; i >= 1; --i) {
                down[i] = down[i-1];
            }

            right[0] = leftTop;
            down[0] = rightBottom;
            left[0] = bottom;
        }
        return;
    }
}