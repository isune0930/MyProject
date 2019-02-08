package P02098_TSP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	static int N, W[][], D[][], MAX = 1000000000;

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/2098.txt");
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.valueOf(st.nextToken());
		W = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.valueOf(st.nextToken());
			}
		}

		D = new int[1 << N][N];
		for (int i = 0; i < (1 << N); i++) {
			for (int j = 0; j < N; j++) {
				D[i][j] = MAX;
			}
		}

		D[1][0] = 0;
		for (int i = 0; i < (1 << N); i++) {
			for (int j = 1; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					for (int k = 0; k < N; k++) {
						if (k != j && (i & (1 << k)) != 0 && W[k][j] != 0) {
							D[i][j] = Math.min(D[i][j], D[i - (1 << j)][k]
									+ W[k][j]);
						}
					}
				}
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i < N; i++) {
			if (W[i][0] != 0) {
				ans = Math.min(ans, D[(1 << N) - 1][i] + W[i][0]);
			}
		}
		System.out.println(ans);		

	}
}
