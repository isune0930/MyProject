package P12019_ClubRoomCleaning_DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Main3 {
	public static long gcd(long a, long b) {
		b %= a;
		if (b == 0)
			return a;
		return gcd(b, a);
	}

	public static void main(String[] args) throws Exception {

		long start = System.currentTimeMillis();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		FileReader fr = new FileReader("C:/BOJ/12019.txt");
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer s = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(s.nextToken());
		int M = Integer.parseInt(s.nextToken());
		M = Math.min(M, N);
		int[] people = new int[N];
		s = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(s.nextToken());
		}
		int[][] arr = new int[N + 1][N + 1];
		int[] sum = new int[N + 1];
		for (int i = 0; i < N; i++) {
			sum[i + 1] = sum[i] + people[i];
		}
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j <= N; j++) {
				arr[i][j] = arr[i][j - 1] + people[j - 1]
						* (sum[j - 1] - sum[i]);
			}
		}
		int[][][] min = new int[N + 1][M + 1][2];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				min[i][j][0] = Integer.MAX_VALUE;
			}
		}
		min[0][0][0] = 0;
		for (int i = 1; i < N; i++) {
			for (int j = 1; j <= M; j++) {
				for (int k = 0; k < i; k++) {
					if (min[k][j - 1][0] != Integer.MAX_VALUE
							&& min[k][j - 1][0] + arr[k][i] < min[i][j][0]) {
						min[i][j][0] = min[k][j - 1][0] + arr[k][i];
						min[i][j][1] = k;
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			if (min[i][M - 1][0] != Integer.MAX_VALUE
					&& min[i][M - 1][0] + arr[i][N] < min[N][M][0]) {
				min[N][M][0] = min[i][M - 1][0] + arr[i][N];
				min[N][M][1] = i;
			}
			if (min[i][M][0] != Integer.MAX_VALUE
					&& min[i][M][0] + arr[i][N] < min[N][M][0]) {
				min[N][M][0] = min[i][M][0] + arr[i][N];
				min[N][M][1] = i;
			}
		}
		bw.write(min[N][M][0] + "\n");
		int[] day = new int[M];
		int k = N;
		if (M != N) {
			k = min[N][M][1];
		}
		for (int i = 0; i < M; i++) {
			day[i] = k;
			k = min[k][M - i][1];
		}
		for (int i = 0; i < M; i++) {
			bw.write(day[M - i - 1] + " ");
		}
		bw.write("\n");
		long end = System.currentTimeMillis();
		bw.write(end - start + " ms" + "\n");
		bw.close();

		// System.out.println(end - start + " ms");

	}
}