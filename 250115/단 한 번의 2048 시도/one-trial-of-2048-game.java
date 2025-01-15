import java.util.*;

public class Main {
    private static final int BLANK = 0;
    private static int N = 4;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 4;  
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        char direction = sc.next().charAt(0);

        sc.close();

        gravityByDirection(arr, direction);
        assembleNumber(arr, direction);
        gravityByDirection(arr, direction);
        
        print(arr);
        
        return;
    }

    private static void gravityByDirection(int[][] arr, char direction) {
        if (direction == 'L') {
            for (int i = 0; i < 4; ++i) {
                int[] temp = new int[4];
                int endOfTempArr = 0;
                for (int j = 0; j < 4; ++j) {
                    if (arr[i][j] != BLANK) {
                        temp[endOfTempArr++] = arr[i][j];
                    }
                }
                for (int j = 0; j < 4; ++j) {
                    arr[i][j] = temp[j];
                }
            }
        } else if (direction == 'R') {
            for (int i = 0; i < 4; ++i) {
                int[] temp = new int[4];
                int endOfTempArr = 3;
                for (int j = 3; j >= 0; --j) {
                    if (arr[i][j] != BLANK) {
                        temp[endOfTempArr--] = arr[i][j];
                    }
                }
                for (int j = 3; j >= 0; --j) {
                    arr[i][j] = temp[j];
                }
            }
        } else if (direction == 'U') {
            for (int j = 0; j < 4; ++j) {
                int[] temp = new int[4];
                int endOfTempArr = 0;
                for (int i = 0; i < 4; ++i) {
                    if (arr[i][j] != BLANK) {
                        temp[endOfTempArr++] = arr[i][j];
                    }
                }
                for (int i = 0; i < 4; ++i) {
                    arr[i][j] = temp[i];
                }
            }
        } else if (direction == 'D') {
            for (int j = 0; j < 4; ++j) {
                int[] temp = new int[4];
                int endOfTempArr = 3;
                for (int i = 3; i >= 0; --i) {
                    if (arr[i][j] != BLANK) {
                        temp[endOfTempArr--] = arr[i][j];
                    }
                }
                for (int i = 3; i >= 0; --i) {
                    arr[i][j] = temp[i];
                }
            }
        }
    }

    private static void assembleNumber(int[][] arr, char direction) {
        if (direction == 'L') {
            for (int i = 0; i < 4; ++i) {
                for (int j = 1; j < 4; ++j) {
                    if (arr[i][j-1] == arr[i][j]) {
                        arr[i][j-1] += arr[i][j];
                        arr[i][j] = BLANK;
                    }
                }
                
            }
        } else if (direction == 'R') {
            for (int i = 0; i < 4; ++i) {
                for (int j = 3; j > 0; --j) {
                    if (arr[i][j-1] == arr[i][j]) {
                        arr[i][j] += arr[i][j-1];
                        arr[i][j-1] = BLANK;
                    }
                }
            }
        } else if (direction == 'U') {
            for (int j = 0; j < 4; ++j) {
                for (int i = 1; i < 4; ++i) {
                    if (arr[i-1][j] == arr[i][j]) {
                        arr[i-1][j] += arr[i][j];
                        arr[i][j] = BLANK;
                    }
                }
            }
        } else if (direction == 'D') {
            for (int j = 0; j < 4; ++j) {
                for (int i = 3; i > 0; --i) {
                    if (arr[i-1][j] == arr[i][j]) {
                        arr[i][j] += arr[i-1][j];
                        arr[i-1][j] = BLANK;
                    }
                }
            }
        }
    }

    private static void print(int[][] arr) {
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}