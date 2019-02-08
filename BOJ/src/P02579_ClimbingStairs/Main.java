package P02579_ClimbingStairs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	static int N, A[], D[];

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/2579.txt");
		BufferedReader br = new BufferedReader(fr);

		N = Integer.parseInt(br.readLine());

		A = new int[N + 1];
		D = new int[N + 1];

		for (int i = 1; i <= 3 && i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
			if (i != 3)
				D[i] = D[i - 1] + A[i];
			else
				D[i] = Math.max(D[i - 2], A[i - 1]) + A[i];
		}
		
		for (int i = 4; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
			D[i] = Math.max(D[i - 3] + A[i - 1], D[i - 2]) + A[i];
		}
		
		System.out.println(D[N]);

	}
}
