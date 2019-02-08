package P01149_RGBStreet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	static int N, R, G, B, D[][];

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/1149.txt");
		BufferedReader br = new BufferedReader(fr);

		N = Integer.parseInt(br.readLine());

		D = new int[3][N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		D[0][1] = Integer.parseInt(st.nextToken());
		D[1][1] = Integer.parseInt(st.nextToken());
		D[2][1] = Integer.parseInt(st.nextToken());

		for (int i = 2; i <= N; i++) {

			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			G = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			D[0][i] = Math.min(D[1][i - 1], D[2][i - 1]) + R;
			D[1][i] = Math.min(D[0][i - 1], D[2][i - 1]) + G;
			D[2][i] = Math.min(D[0][i - 1], D[1][i - 1]) + B;
		}

		System.out.println(Math.min(Math.min(D[0][N], D[1][N]), D[2][N]));
	}
}
