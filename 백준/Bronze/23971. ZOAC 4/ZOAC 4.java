import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long H = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long rows = (H + N) / (N + 1);
        long cols = (W + M) / (M + 1);

        System.out.println(rows * cols);
    }
}