package P02156_WineTasting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	static int N, W[], D[];

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/2156.txt");
		BufferedReader br = new BufferedReader(fr);

		N = Integer.parseInt(br.readLine());

		W = new int[N + 1];
		D = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			W[i] = Integer.parseInt(br.readLine());
			if (i <= 2)
				D[i] = D[i - 1] + W[i];
			else
				D[i] = Math.max(Math.max(D[i - 2], D[i - 3] + W[i - 1]) + W[i], D[i - 1]);
		}

		System.out.println(D[N]);

	}
}