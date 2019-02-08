package P01932_NumberTriangle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	static int N, A[][], D[][], ans;

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/1932.txt");
		BufferedReader br = new BufferedReader(fr);

		N = Integer.parseInt(br.readLine());
		A = new int[N][N];
		D = new int[N][N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		A[0][0] = Integer.parseInt(st.nextToken());
		D[0][0] = A[0][0];

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				if (j == 0)
					D[i][j] = D[i - 1][j] + A[i][j];
				else if (j == i)
					D[i][j] = D[i - 1][j - 1] + A[i][j];
				else
					D[i][j] = Math.max(D[i - 1][j - 1], D[i - 1][j]) + A[i][j];
			}
		}

		ans = D[N - 1][0];
		for (int i = 1; i < N; i++)
			ans = Math.max(ans, D[N - 1][i]);

		System.out.println(ans);

	}

}