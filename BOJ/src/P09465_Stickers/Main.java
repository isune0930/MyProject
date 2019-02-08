package P09465_Stickers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	static int T, N, A[][], D[][];

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/9465.txt");
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.valueOf(st.nextToken());

		for (int ts = 1; ts <= T; ts++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.valueOf(st.nextToken());
			A = new int[3][N + 1];
			D = new int[3][N + 1];

			for (int i = 1; i <= 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++)
					A[i][j] = Integer.valueOf(st.nextToken());
			}

			D[1][1] = A[1][1];
			D[2][1] = A[2][1];

			for (int i = 2; i <= N; i++)
				for (int j = 1; j <= 2; j++)
					D[j][i] = Math.max(Math.max(D[j][i - 2], D[3 - j][i - 2]),
							D[3 - j][i - 1]) + A[j][i];

			System.out.println(Math.max(D[1][N], D[2][N]));

		}

	}

}