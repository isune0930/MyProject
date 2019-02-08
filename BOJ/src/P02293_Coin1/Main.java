package P02293_Coin1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K, A[], D[];

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/2293.txt");
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N + 1];
		D = new int[K + 1];

		D[0] = 1;
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
			for (int j = A[i]; j <= K; j++)
				D[j] += D[j - A[i]];
		}

		System.out.println(D[K]);

	}
}