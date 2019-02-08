package P02225_SumDecomposition_DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	static int N, K, D[][];
	final static int MOD = 1000000000;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		D = new int[K + 1][N + 1];
		D[0][0] = 1;
		for (int i = 1; i <= K; i++) {
			for (int j = 0; j <= N; j++) {
				D[i][j] = D[i - 1][j];
				D[i][j] += ((j > 0) ? D[i][j - 1] : 0);
				D[i][j] %= MOD;
			}
		}
		System.out.println(D[K][N]);

	}

}