package P11057_AscentNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, D[][], ans;
	static int mod = 10007;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());

		D = new int[N + 1][10];
		for (int i = 0; i <= 9; i++)
			D[1][i] = 1;

		for (int i = 2; i <= N; i++)
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= j; k++)
					D[i][j] += D[i - 1][k];
				D[i][j] %= mod;
			}

		for (int i = 0; i <= 9; i++)
			ans += D[N][i];

		System.out.println(ans % mod);

	}

}