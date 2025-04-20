import java.util.Scanner;

public class Main {
	private static long N = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextLong();
		System.out.println(solution());
	}

	private static long solution() {
		long result = 0;

		for (int i = 0; i < N; ++i) {
			result += (N+1) * i;
		}

		return result;
	}
}
