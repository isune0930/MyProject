package ZZ_P13711_LCS4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, A[], B[], D[][];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		B = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			B[i] = Integer.parseInt(st.nextToken());

		D = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++) {
				D[i][j] = Math.max(D[i - 1][j], D[i][j - 1]);
				if (A[i] == B[j])
					D[i][j] = Math.max(D[i][j], D[i - 1][j - 1] + 1);
			}

		System.out.println(D[N][N]);

	}

}