package P09095_Adding1s2sAnd3s_DP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	static int T, N, D[];

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/9095.txt");
		BufferedReader br = new BufferedReader(fr);

		D = new int[11];
		D[1] = 1;
		D[2] = 2;
		D[3] = 4;
		for (int i = 4; i <= 10; i++)
			D[i] = D[i - 1] + D[i - 2] + D[i - 3];

		T = Integer.parseInt(br.readLine());
		for (int ts = 1; ts <= T; ts++) {
			N = Integer.parseInt(br.readLine());
			System.out.println(D[N]);
		}

	}
}
