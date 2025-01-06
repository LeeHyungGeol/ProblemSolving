import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); 

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" "); 
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }
        sc.close();

        int answer = 0;

        for (int i = 0; i < n-2; ++i) {
            for (int j = 0; j < n-2; ++j) {
                answer = Math.max(answer, getCount(arr, i,j));
            }
        }

        System.out.println(answer);
    }

    private static int getCount(int[][] arr, int x, int y) {
        int count = 0;

        for (int i = x; i < x+3; ++i) {
            for (int j = y; j <y+3; ++j) {
                if (arr[i][j] == 1) {
                    ++count;
                }
            }
        }

        return count;
    } 
}