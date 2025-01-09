import java.util.*;

public class Main {
    private static int N = 0;
    private static int M = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();

        N = n;
        M = m;
        int answer = 0;

        for (int x = 0; x < n; ++x) {
            for (int y = 0; y < m; ++y) {
                for (int x2 = x; x2 < n; ++x2) {
                    for (int y2 = y; y2 < m; ++y2) {
                        if (isAllPlus(arr, x,y,x2,y2)) {
                            answer = Math.max(answer, getArea(x,y,x2,y2));
                        }
                    }
                }
            }
        }   

        System.out.println(answer);
        return;
    }

    private static boolean isAllPlus(int[][] arr, int x, int y, int x2, int y2) {
        for (int i = x; i <= x2; ++i) {
            for (int j = y; j <= y2; ++j) {
                if (arr[i][j] < 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int getArea(int x, int y, int x2, int y2) {
        return (Math.abs(x-x2)+1) * (Math.abs(y-y2)+1);
    }
}