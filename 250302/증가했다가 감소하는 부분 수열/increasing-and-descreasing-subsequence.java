import java.util.Scanner;

public class Main {
    public static final int MAX_K = 2;
    public static final int MAX_N = 1000;
    
    public static int n;
    public static int[] arr = new int[MAX_N];
    
    public static int[][] dp = new int[MAX_N][MAX_K];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
            dp[i][1] = 1;

            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i])
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
                
                if(arr[j] > arr[i])
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
            }

            dp[i][1] = Math.max(dp[i][1], dp[i][0]);
        }

        int ans = 0;
        for(int i = 0; i < n; i++)
            ans = Math.max(ans, dp[i][1]);

        System.out.print(ans);
    }
}
