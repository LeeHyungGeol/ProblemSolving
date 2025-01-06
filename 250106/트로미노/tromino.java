import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < m; j++) {
                if (st.hasMoreTokens()) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
        br.close();

        int answer = 0;
        for (int count = 0; count < 4; ++count) {
            arr = rotate90(arr);

            answer = Math.max(answer, Math.max(sumBlock1(arr, arr.length, arr[0].length), sumBlock2(arr, arr.length, arr[0].length)));
        }

        System.out.println(answer);
        return;
    }

    private static int[][] rotate90(int[][] arr) {
        int n = arr.length;  
        int m = arr[0].length; 
        int[][] rotated = new int[m][n];

        // 90도 회전 로직
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][n - 1 - i] = arr[i][j];
            }
        }
        return rotated;
    }

    private static int sumBlock1(int[][] arr, int n, int m) {
        int sum = 0;

        for (int i = 0; i < n-1; ++i) {
            for (int j = 0; j < m-1; ++j) {
                sum = Math.max(sum, arr[i][j]+arr[i+1][j]+arr[i+1][j+1]);
            }
        }

        return sum;
    }

    private static int sumBlock2(int[][] arr, int n, int m) {
        int sum = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m-2; ++j) {
                sum = Math.max(sum, arr[i][j]+arr[i][j+1]+arr[i][j+2]);
            }
        }

        return sum;
    }
}
