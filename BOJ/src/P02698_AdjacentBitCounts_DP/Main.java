package P02698_AdjacentBitCounts_DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int T, N, K, D[][][];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		D = new int[101][100][2];
		D[1][0][0] = 1;
		D[1][0][1] = 1;
		for (int i = 2; i <= 100; i++)
			for (int j = 0; j < i; j++) {
				D[i][j][0] = D[i - 1][j][0] + D[i - 1][j][1];
				D[i][j][1] = D[i - 1][j][0]
						+ ((j > 0) ? D[i - 1][j - 1][1] : 0);
			}

		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			bw.write(D[N][K][0] + D[N][K][1] + "\n");
		}
		bw.flush();

	}

}