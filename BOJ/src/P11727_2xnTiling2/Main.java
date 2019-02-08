package P11727_2xnTiling2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N, D[], mod = 10007;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		if (N == 1)
			System.out.println(1);
		else if (N == 2)
			System.out.println(3);
		else {
			D = new int[N + 1];
			D[1] = 1;
			D[2] = 3;
			for (int i = 3; i <= N; i++)
				D[i] = (D[i - 1] + 2 * D[i - 2]) % mod;
			System.out.println(D[N]);
		}

	}
}