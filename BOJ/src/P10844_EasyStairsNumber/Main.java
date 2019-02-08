package P10844_EasyStairsNumber;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N, D[][];
	static long ans;
	static int mod = 1000000000;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		D = new int[N + 1][10];

		for (int i = 1; i < 10; i++)
			D[1][i] = 1;

		for (int i = 2; i <= N; i++)
			for (int j = 0; j < 10; j++) {
				if (j - 1 >= 0)
					D[i][j] += D[i - 1][j - 1];
				if (j + 1 <= 9)
					D[i][j] += D[i - 1][j + 1];
				D[i][j] = D[i][j] % mod;
			}

		for (int i = 0; i < 10; i++)
			ans += D[N][i];

		System.out.println(ans % mod);

	}

}