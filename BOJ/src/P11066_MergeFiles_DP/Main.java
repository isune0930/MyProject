package P11066_MergeFiles_DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int T, K, C[], S[], D[][];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			K = Integer.parseInt(br.readLine());
			C = new int[K + 1];
			S = new int[K + 1];
			D = new int[K + 1][K + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= K; i++) {
				C[i] = Integer.parseInt(st.nextToken());
				S[i] = S[i - 1] + C[i];
				Arrays.fill(D[i], -1);
			}
			bw.write(go(1, K) + "\n");
		}
		bw.flush();

	}

	static int go(int i, int j) {
		if (D[i][j] != -1)
			return D[i][j];
		if (i == j)
			return D[i][j] = 0;
		D[i][j] = Integer.MAX_VALUE;
		for (int k = i; k < j; k++)
			D[i][j] = Math.min(D[i][j], go(i, k) + go(k + 1, j) + S[j]
					- S[i - 1]);
		return D[i][j];
	}

}