import java.util.*;

public class Main {
    private static int Counter = 0;
    private static final int BLANK = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] blocks = new int[n];
        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
        }

        List<int[]> queries = new ArrayList<>();
        while (sc.hasNextInt()) { 
            int s = sc.nextInt();
            int e = sc.nextInt();
            queries.add(new int[]{s, e});
        }

        sc.close(); 

        Counter = n;

        for (int[] query : queries) {
            int s = query[0]-1;
            int e = query[1]-1;

            blocks = removeBlocks(blocks, s, e);
        }

        if (Counter > 0) {
            System.out.println(Counter);
            for (int i = 0; i < blocks.length; ++i) {
                if (blocks[i] != BLANK) {
                    System.out.println(blocks[i]);
                }
            }
        } else {
            System.out.println("0");
        }
        return;
    }

    private static int[] removeBlocks(int[] blocks, int s, int e) {
        for (int i = s; i <= e; ++i) {
            blocks[i] = BLANK;
            --Counter;
        }

        int[] tempBlocks = new int[Counter];
        int endOfTemp = 0;

        for (int i = 0; i < blocks.length; ++i) {
            if (blocks[i] != BLANK) {
                tempBlocks[endOfTemp++] = blocks[i];
            }
        }

        return tempBlocks;
    }
}