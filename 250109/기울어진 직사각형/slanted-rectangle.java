import java.util.*;
import java.io.*;

public class Main {
    private static int N = 0;
    private static int[] DX = {1,-1,-1,1};
    private static int[] DY = {1,1,-1,-1};

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int[][] arr = new int[n][n]; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();

        N = n;
        int answer = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int w = 1; w < n; ++w) {
                    for (int h = 1; h < n; ++h) {
                        answer = Math.max(answer, getSum(arr, i,j,w,h));
                    }
                }
            }
        }
        
        System.out.println(answer);
        return;
    }

    private static int getSum(int[][] arr, int x, int y, int width, int height) {
        int result = 0;
        int[] length = {width, height, width, height};

        for (int d = 0; d < 4; ++d) {
            for (int step = 0; step < length[d]; ++step) {
                x += DX[d];
                y += DY[d];

                if (!isInRange(x, y)) {
                    return 0;
                }
                result += arr[x][y];
            } 
        }

        return result;
    }

    private static boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}