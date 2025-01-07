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

        for (int k = 0; k <= 2*(n-1); ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (k == 0) {
                        if (inRange(i,j, arr.length) && arr[i][j] == 1) {
                            if(m >= getMineCost(k)) {
                                answer = Math.max(answer, 1);
                            }
                        }
                        continue;
                    }
                    int goldCount = getGoldCount(arr,i,j,k);
                    int goldMoney = goldCount * m;

                    if(goldMoney > getMineCost(k)) {
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
        int blockCount = 0;

        for (int limit = -k; limit <= k; ++limit) {
            if (limit <= 0) {
                for (int j = -(limit+k); j <= (limit+k); ++j) {
                    if (inRange(x+limit, y+j, arr.length) && arr[x+limit][y+j] == 1) {
                        ++goldCount;
                    }
                }
            } else {
                for (int j = (limit-k); j <= (limit-k); ++j) {
                    if (inRange(x+limit, y+j, arr.length) && arr[x+limit][y+j] == 1) {
                        ++goldCount;
                    }
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
