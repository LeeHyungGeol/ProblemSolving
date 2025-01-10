import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int[][] arr = new int[2][n];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close(); 

        int rowToReverse = 1; // 두 번째 행(인덱스 1)만 뒤집기
        reverseRow(arr, rowToReverse);

        for (int i = 0; i < t; ++i) {
            rotate(arr, n);
        }

        reverseRow(arr, rowToReverse);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }

        return;
    }

    static void reverseRow(int[][] arr, int row) {
        int left = 0, right = arr[row].length - 1;
        while (left < right) {
            int temp = arr[row][left];
            arr[row][left] = arr[row][right];
            arr[row][right] = temp;
            left++;
            right--;
        }
    }
    
    private static void rotate(int[][] arr, int n) {
        int rightTop = arr[0][n-1];
        int leftBottom = arr[1][0];

        for (int i = n-1; i >= 1; --i) {
            arr[0][i] = arr[0][i-1];
        }
        for (int i = 1; i <= n-1; ++i) {
            arr[1][i-1] = arr[1][i];
        }
        arr[1][n-1] = rightTop;
        arr[0][0] = leftBottom;
        return;
    }
}