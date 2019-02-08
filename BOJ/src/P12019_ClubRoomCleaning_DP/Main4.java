package P12019_ClubRoomCleaning_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main4 {

	static int N, M, A[], dp[][], v[][], t[];

	public static void main(String[] args) throws IOException {

		long start = System.currentTimeMillis();

		// FileReader fr = new FileReader("C:/BOJ/12019.txt");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		A = new int[N + 2];
		for (int i = 1; i <= N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		dp = new int[N + 2][M + 2];
		for (int[] row : dp)
			Arrays.fill(row, Integer.MAX_VALUE);
		v = new int[N + 2][M + 2];

		for (int i = 1; i <= N + 1; i++) {
			int s = 0, r = 0;
			for (int l = 1; l <= i - 1; l++) {
				s += A[l];
				r += s * A[l + 1];
			}
			dp[i][0] = r;
			dp[i][1] = dp[i - 1][0];
			for (int j = 2; j <= M + 1; j++) {
				for (int k = 1; k < i; k++) {
					if (j > k)
						continue;
					s = 0;
					r = 0;
					for (int l = k; l <= i - 2; l++) {
						s += A[l];
						r += s * A[l + 1];
					}
					if (dp[i][j] > dp[k][j - 1] + r) {
						dp[i][j] = dp[k][j - 1] + r;
						v[i][j] = k;
					}
				}
			}
		}

		System.out.println(dp[N + 1][M + 1]);

		int pc = 0;
		int i = N + 1, j = M + 1;
		t = new int[N + 2];
		for (;;) {
			if (j == 1)
				break;
			i = v[i][j];
			j--;
			t[++pc] = i;
		}
		for (i = pc; i >= 1; i--) {
			System.out.print(t[i] - 1 + " ");
		}

		System.out.println();
		long end = System.currentTimeMillis();
		System.out.println(end - start + " ms");

	}

}