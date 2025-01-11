import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        List<String> commands = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int num = sc.nextInt();
            String str = sc.next();
            commands.add(num + " " + str);
        }

        sc.close();

        for (String command : commands) {
            String[] splitted = command.split(" ");
            int row = Integer.parseInt(splitted[0])-1;
            String direction = splitted[1];

            wind(arr, row, m, direction);
            checkUp(arr, row, m, direction);
            checkDown(arr, row, m, direction);
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
        return;
    }

    private static void wind(int[][] arr, int row, int m, String direction) {
        if (direction.equals("L")) {
            leftShift(arr, row, m);
        } else {
            rightShift(arr, row, m);
        }
        return;
    }

    private static void checkUp(int[][] arr, int row, int m, String direction) {
        if (row == 0) {
            return;
        }
        if (check(arr, row, row-1)) {
            if (direction.equals("L")) {
                rightShift(arr, row-1, m);
                checkUp(arr, row-1, m, "R");
            } else {
                leftShift(arr, row-1, m);
                checkUp(arr, row-1, m, "L");
            }
        }
    }

    private static void checkDown(int[][] arr, int row, int m, String direction) {
        if (row == arr.length-1) {
            return;
        }
        if (check(arr, row, row+1)) {
            if (direction.equals("L")) {
                rightShift(arr, row+1, m);
                checkDown(arr, row+1, m, "R");
            } else {
                leftShift(arr, row+1, m);
                checkDown(arr, row+1, m, "L");
            }
        }
    }

    private static boolean check(int[][] arr, int rowA, int rowB) {
        for (int i = 0; i < arr[0].length; ++i) {
            if (arr[rowA][i] == arr[rowB][i]) {
                return true;
            }
        }
        return false;
    }

    private static void leftShift(int[][] arr, int row, int m) {
        int rightEnd = arr[row][m-1];

        for (int i = m-1; i >= 1; --i) {
            arr[row][i] = arr[row][i-1];
        }

        arr[row][0] = rightEnd;
        return;
    }
    

    private static void rightShift(int[][] arr, int row, int m) {
        int leftEnd = arr[row][0];

        for (int i = 0; i <= m-2; ++i) {
            arr[row][i] = arr[row][i+1];
        }

        arr[row][m-1] = leftEnd;
        return;
    }
}