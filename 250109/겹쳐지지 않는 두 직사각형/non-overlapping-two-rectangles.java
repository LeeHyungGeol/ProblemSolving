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
        int answer = Integer.MIN_VALUE;

        for (int x = 0; x < n; ++x) {
            for (int y = 0; y < m; ++y) {
                for (int x2 = x; x2 < n; ++x2) {
                    for (int y2 = y; y2 < m; ++y2) {
                        answer = Math.max(answer, findTwoMaxRectangle(arr, x,y,x2,y2));
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static int findTwoMaxRectangle(int[][] arr, int x, int y, int x2, int y2) {
        int result = Integer.MIN_VALUE;
        int sumOfrectangle1 = getSum(arr, x,y,x2,y2);

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                for (int i2 = i; i2 < N; ++i2) {
                    for (int j2 = j; j2 < M; ++j2) {
                        if (isNotOverlapped(x,y,x2,y2, i,j,i2,j2)) {
                            int sumOfrectangle2 = getSum(arr, i,j,i2,j2);
                            result = Math.max(result, sumOfrectangle1+sumOfrectangle2);
                        }
                    }
                }
            }
        }

        return result;
    }

    private static boolean isNotOverlapped(int x, int y, int x2, int y2, int i, int j, int i2, int j2) {
        boolean[][] visited = new boolean[N][M];

        for (int a = x; a <= x2; ++a) {
            for (int b = y; b <= y2; ++b) {
                visited[a][b] = true;
            }
        }

        for (int a = i; a <= i2; ++a) {
            for (int b = j; b <= j2; ++b) {
                if (visited[a][b]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int getSum(int[][] arr, int x, int y, int x2, int y2) {
        int result = 0;

        for (int i = x; i <= x2; ++i) {
            for (int j = y; j <= y2; ++j) {
                result += arr[i][j];
            }
        }

        return result;
    }
}