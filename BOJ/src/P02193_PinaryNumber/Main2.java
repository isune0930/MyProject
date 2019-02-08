package P02193_PinaryNumber;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {

	static int N;
	static long D[][];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		D = new long[N + 1][2];
		D[1][0] = 0;
		D[1][1] = 1;
		for (int i = 2; i <= N; i++) {
			D[i][0] = D[i - 1][0] + D[i - 1][1];
			D[i][1] = D[i - 1][0];
		}

		System.out.println(D[N][0] + D[N][1]);

	}

}