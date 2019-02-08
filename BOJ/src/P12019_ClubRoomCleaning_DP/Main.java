package P12019_ClubRoomCleaning_DP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, P[], dp[][][];	

	public static void main(String[] args) throws IOException {

		long start = System.currentTimeMillis();

		FileReader fr = new FileReader("C:/BOJ/12019.txt");
		// InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(fr);

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		P = new int[N];
		for (int i = 0; i < N; i++)
			P[i] = Integer.parseInt(st.nextToken());

		dp = new int[100][11][2001];
		for (int[][] square : dp)
			for (int[] line : square)
				Arrays.fill(line, -1);		

		System.out.println(leastDirty(0, M, 0));
		trace(0, M, 0);

		System.out.println();
		long end = System.currentTimeMillis();
		System.out.println(end - start + " ms");

	}

	static int leastDirty(int day, int m, int d) {
		if (day == N)
			return 0;
		int ret = dp[day][m][d];
		if (ret != -1)
			return ret;
		ret = leastDirty(day + 1, m, d + P[day]);
		if (m > 0)
			ret = Math.min(ret, leastDirty(day + 1, m - 1, 0));
		return ret += d * P[day];
	}

	static void trace(int day, int m, int d) {
		if (day == N)
			return;
		if (m > 0
				&& leastDirty(day + 1, m - 1, 0) <= leastDirty(day + 1, m, d
						+ P[day])) {
			System.out.print(day + 1 + " ");
			trace(day + 1, m - 1, 0);
		} else
			trace(day + 1, m, d + P[day]);

	}

}
