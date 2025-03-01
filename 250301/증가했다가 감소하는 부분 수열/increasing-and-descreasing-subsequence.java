import java.util.*;

public class Main {
    static int N = 0, Answer = 0;
    static int[] Arr, LIS, LDS;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();

        Arr = new int[N];
        LIS = new int[N];
        LDS = new int[N];

        for (int i = 0; i < N; ++i) {
            Arr[i] = sc.nextInt();
        }

        Arrays.fill(LIS, 1);
        Arrays.fill(LDS, 1);

        for (int i = 1; i < N; ++i) {
            for (int j = 0; j < i; ++j) {
                if (Arr[j] < Arr[i]) {
                    LIS[i] = Math.max(LIS[i], LIS[j]+1);
                }
            }
        }

        for (int i = N-1; i >= 0; --i) {
            for (int j = i+1; j < N; ++j) {
                if (Arr[j] < Arr[i]) {
                    LDS[i] = Math.max(LDS[i], LDS[j]+1);
                }
            }
        }

        for (int i = 0; i < N; ++i) {
            Answer = Math.max(Answer, LIS[i] + LDS[i] - 1);
        }

        System.out.println(Answer);
    }
}