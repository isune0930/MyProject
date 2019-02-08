package P01010_BridgeLaying;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	static int C[][], T, N, M;

	public static void main(String[] args) throws IOException {

		C = new int[31][31];
		C[0][0] = 1;
		for (int i = 1; i <= 30; i++)
			for (int j = 0; j <= i; j++) {
				if (j == 0 | j == i)
					C[i][j] = 1;
				else
					C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
			}

		FileReader fr = new FileReader("C:/BOJ/1010.txt");
		BufferedReader br = new BufferedReader(fr);

		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());

		for (int ts = 1; ts <= T; ts++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			System.out.println(C[M][N]);
		}

	}

}