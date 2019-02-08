package P01520_Downhill;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	static int M, N, A[][], D[][];
	static boolean check[][];

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/1520.txt");
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.valueOf(st.nextToken());
		N = Integer.valueOf(st.nextToken());
		A = new int[M + 1][N + 1];
		D = new int[M + 1][N + 1];
		check = new boolean[M + 1][N + 1];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				A[i][j] = Integer.valueOf(st.nextToken());
		}

		D[1][1] = 1;
		check[1][1] = true;

		System.out.println(dh(M, N));

	}

	static int dh(int x, int y) {
		if (check[x][y])
			return D[x][y];
		if (x - 1 >= 1 && A[x][y] < A[x - 1][y])
			D[x][y] += dh(x - 1, y);
		if (x + 1 <= M && A[x][y] < A[x + 1][y])
			D[x][y] += dh(x + 1, y);
		if (y - 1 >= 1 && A[x][y] < A[x][y - 1])
			D[x][y] += dh(x, y - 1);
		if (y + 1 <= N && A[x][y] < A[x][y + 1])
			D[x][y] += dh(x, y + 1);
		check[x][y] = true;
		return D[x][y];
	}

}