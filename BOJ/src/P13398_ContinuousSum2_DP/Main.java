package P13398_ContinuousSum2_DP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Main {

	static int n, A[], DL[], DR[], max;

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/13398.txt");
		BufferedReader br = new BufferedReader(fr);

		n = Integer.valueOf(br.readLine());
		A = new int[n + 1];
		DL = new int[n + 1];
		DR = new int[n + 1];
		max = -1000;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			A[i] = Integer.valueOf(st.nextToken());
			DL[i] = Math.max(DL[i - 1], 0) + A[i];
			max = Math.max(max, DL[i]);
		}

		DR[n] = A[n];
		for (int i = n - 1; i > 0; i--) {
			DR[i] = Math.max(DR[i + 1], 0) + A[i];
		}

		for (int i = 1; i <= n - 2; i++) {
			max = Math.max(max, DL[i] + DR[i + 2]);
		}

		System.out.println(max);

	}

}