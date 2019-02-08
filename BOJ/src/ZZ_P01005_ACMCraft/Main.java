/*런타임 오류
 2차원 배열의 크기 때문인듯 함
  위상 정렬 후 다이나믹으로 풀이 해야 함*/

package ZZ_P01005_ACMCraft;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Main {

	static int T, N, K, D[], X, Y, W, dp[];

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/1005.txt");
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());

		for (int ts = 1; ts <= T; ts++) {

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			D = new int[N + 1];
			dp = new int[N + 1];

			K = Integer.parseInt(st.nextToken());
			boolean[][] tech = new boolean[K + 1][K + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++)
				dp[i] = D[i] = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= K; i++) {
				st = new StringTokenizer(br.readLine());
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());
				tech[X][Y] = true;
			}

			W = Integer.parseInt(br.readLine());

			for (int j = 2; j <= W; j++)
				for (int i = 1; i < j; i++)
					if (tech[i][j])
						dp[j] = Math.max(dp[j], dp[i] + D[j]);

			System.out.println(dp[W]);

		}

	}

}