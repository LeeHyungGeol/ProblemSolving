import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < n; j++) {
                if (st.hasMoreTokens()) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        br.close(); 

        int answer = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k <= 2*(n-1); ++k) {
                    int goldCount = getGoldCount(arr,i,j,k);
                    int goldMoney = goldCount * m;

                    if(goldMoney >= getMineCost(k)) {
                        answer = Math.max(answer, goldCount);
                    }
                }
            }
        }
        
        System.out.println(answer);
        return;
    }

    private static int getGoldCount(int[][] arr, int x, int y, int k) {
        int goldCount = 0;

        for (int i=0; i< arr.length; i++) {
            for (int j=0; j< arr[i].length; j++) {
                if (Math.abs(i-x) + Math.abs(j-y) <= k) { 
                    goldCount += arr[i][j];
                }
            }
        }
        return goldCount;
    }

    private static boolean inRange(int x, int y, int n) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    private static int getMineCost(int k) {
        return (k*k) + (k+1)*(k+1);
    }
}
