package P01915_LargestSquare;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	static int N, M, A[][], D[][], ans;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("C:/BOJ/1915.txt"));
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		A = new int[N + 1][M + 1];
		D = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String row = sc.next();
			for (int j = 1; j <= M; j++) {
				A[i][j] = Integer.parseInt(row.substring(j - 1, j));
				if (A[i][j] == 0)
					D[i][j] = 0;
				else {
					D[i][j] = Math.min(Math.min(D[i - 1][j], D[i][j - 1]),
							D[i - 1][j - 1]) + 1;
				}
				ans = Math.max(ans, D[i][j]);
			}
		}
		System.out.println(ans * ans);

	}

}