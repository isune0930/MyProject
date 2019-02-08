package P11052_SellingFishShapedBun;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	static int T, N, P[], D[];

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/11052.txt");
		BufferedReader br = new BufferedReader(fr);

		T = Integer.valueOf(br.readLine());

		for (int ts = 1; ts <= T; ts++) {

			N = Integer.valueOf(br.readLine());
			P = new int[N + 1];
			D = new int[N + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++)
				P[i] = Integer.valueOf(st.nextToken());

			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= i; j++)
					D[i] = Math.max(D[i], D[i-j] + P[j]);

			System.out.println("#" + ts + " " + D[N]);

		}

	}

}