package P01003_FibonacciFunction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	static int T, F[][], N;

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/1003.txt");
		// InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(fr);

		F = new int[2][41];

		F[0][0] = 1;
		F[1][0] = 0;
		F[1][0] = 0;
		F[1][1] = 1;

		for (int j = 2; j <= 40; j++)
			for (int i = 0; i <= 1; i++)
				F[i][j] = F[i][j - 1] + F[i][j - 2];

		T = Integer.parseInt(br.readLine());
		for (int ts = 1; ts <= T; ts++) {
			N = Integer.parseInt(br.readLine());
			System.out.println(F[0][N] + " " + F[1][N]);
		}

	}
}