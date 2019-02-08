package P02225_SumDecomposition_DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K, D[][];
	final static int mod = 1000000000;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		D = new int[K + 1][N + 1];
		D[0][0] = 1;
		for (int i = 1; i <= K; i++)
			for (int j = 0; j <= N; j++)
				for (int k = 0; k <= j; k++) {
					D[i][j] += D[i - 1][j - k];
					D[i][j] %= mod;
				}
		System.out.println(D[K][N]);

	}

}