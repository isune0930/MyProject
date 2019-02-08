package P02193_PinaryNumber_DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static long D[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		D = new long[N + 1];
		D[1] = 1;
		for (int i = 2; i <= N; i++)
			D[i] = D[i - 1] + D[i - 2];

		System.out.println(D[N]);

	}
	
}