/*틀렸다고 나오는데 이유를 못찾음*/

package P02169_RobotControl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	static int N, M, A[][], D[][], DL[][], DR[][];

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/2169.txt");
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());

		A = new int[N + 1][M + 1];
		D = new int[N + 1][M + 1];
		DL = new int[N + 1][M + 1];
		DR = new int[N + 1][M + 2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				A[i][j] = Integer.valueOf(st.nextToken());
				if (i == 1)
					D[1][j] = D[1][j - 1] + A[1][j];
			}
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= M; j++)
				DL[i][j] = Math.max(D[i - 1][j], DL[i][j - 1]) + A[i][j];
			for (int j = M; j >= 1; j--)
				DR[i][j] = Math.max(D[i - 1][j], DR[i][j + 1]) + A[i][j];
			for (int j = 1; j <= M; j++)
				D[i][j] = Math.max(DL[i][j], DR[i][j]);
		}

		System.out.println(D[N][M]);

	}

}