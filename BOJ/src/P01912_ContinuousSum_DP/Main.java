package P01912_ContinuousSum_DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, A[], D[], ans;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.valueOf(br.readLine());
		A = new int[n + 1];
		D = new int[n + 1];
		ans = -1000;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			A[i] = Integer.valueOf(st.nextToken());
			D[i] = Math.max(D[i - 1], 0) + A[i];
			ans = Math.max(ans, D[i]);
		}
		System.out.println(ans);

	}

}