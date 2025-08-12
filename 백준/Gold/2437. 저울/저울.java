import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] weights = new int[n];

		for (int i = 0; i < n; ++i) {
			weights[i] = scanner.nextInt();
		}

		Arrays.sort(weights);

		long sum = 1;
		for (int i = 0; i < n; ++i) {
			if (sum < weights[i]) {
				break;
			}
			sum += weights[i];
		}

		System.out.println(sum);
	}
}
