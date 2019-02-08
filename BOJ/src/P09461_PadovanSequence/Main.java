package P09461_PadovanSequence;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int T, N;
	static long D[];

	public static void main(String[] args) throws Exception {

		D = new long[101];
		D[1] = D[2] = D[3] = 1;
		D[4] = 2;
		for (int i = 5; i <= 100; i++)
			D[i] = D[i - 1] + D[i - 5];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int ts = 1; ts <= T; ts++) {
			N = Integer.parseInt(br.readLine());
			System.out.println(D[N]);
		}

	}

}