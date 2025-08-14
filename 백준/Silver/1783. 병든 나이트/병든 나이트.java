import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = 0;
        if (N == 1) {
            count = 1;
        } else if (N == 2) {
            count = Math.min(4, ((M + 1) / 2));
        } else if (M < 7) {
            count = Math.min(4, M); //2,3만 반복하면 M만큼 반복
        } else if(M >= 7){
            count = M - 2;  //1,4번방향 한번씩 움직여야하므로
        }

        System.out.println(count);

    }
}