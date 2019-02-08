package P11726_2xnTiling_DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int n, D[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());

		D = new int[n + 1];
		D[0] = 1;
		D[1] = 1;
		for (int i = 2; i <= n; i++)
			D[i] = (D[i - 1] + D[i - 2]) % 10007;
		System.out.println(D[n]);

	}

}