import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];

        if (n == 1) {
            System.out.println(2);
            return;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int i = 0; i < n; ++i) {
            answer += getCount(arr, i,i,n,m);
        }
       
        br.close(); 

        System.out.println(answer);
    }

    private static int getCount(int[][] arr, int row, int col, int n, int m) {
        int count = 1, result = 0;

        for (int x = 1; x < n; ++x) {
            if(arr[x-1][col] == arr[x][col]) {
                ++count;
            } else {
                count = 1;
            }
            if (count >= m) {
                ++result;
                break;
            }
        }

        count = 1;

        for (int y = 1; y < n; ++y) {
            if (arr[row][y-1] == arr[row][y]) {
                ++count;
            } else {
                count = 1;
            }
             if (count >= m) {
                ++result;
                break;
            }
        }

        return result;
    }
}