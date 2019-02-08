package ZZ_P11053_LongestIncreasingSubsequence_DP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	static int N, A[], D[];

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/11053.txt");
		BufferedReader br = new BufferedReader(fr);

		N = Integer.valueOf(br.readLine());
		A = new int[N + 1];
		D = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.valueOf(st.nextToken());
			if (A[i] > A[i - 1])
				D[i] = D[i - 1] + 1;
			else
				D[i] = D[i - 1];
		}

		System.out.println(D[N]);

	}

}