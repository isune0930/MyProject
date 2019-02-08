package P02167_TwoDimensionalArraysSum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	static int N, M, A[][], D[][], K, I, J, X, Y;

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/2167.txt");
		BufferedReader br = new BufferedReader(fr);

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N + 1][M + 1];
		D = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				D[i][j] = D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + A[i][j];
			}
		}

		K = Integer.parseInt(br.readLine());
		for (int ts = 1; ts <= K; ts++) {
			st = new StringTokenizer(br.readLine());
			I = Integer.parseInt(st.nextToken());
			J = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			System.out.println(D[X][Y] - D[X][J - 1] - D[I - 1][Y]
					+ D[I - 1][J - 1]);
		}

	}

}