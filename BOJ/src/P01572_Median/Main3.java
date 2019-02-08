package P01572_Median;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
			System.out));

	static int n, K, i, L, R, len = 131072;
	static int[] T, tree;

	public static void main(String args[]) throws IOException {
		// Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		T = new int[n + 1];
		for (i = 1; i <= n; i++)
			T[i] = Integer.parseInt(br.readLine());
		tree = new int[len];
		for (i = 1; i <= K; i++)
			segUpdate(T[i] + 1, 1);
		long sum = sol(0, 65536);
		for (i = K + 1; i <= n; i++) {
			segUpdate(T[i - K] + 1, -1);
			segUpdate(T[i] + 1, 1);
			sum += sol(0, 65536);
		}
		bw.write(sum + "");
		bw.close();
	}

	static int sol(int s, int e) {
		int m = (s + e) / 2;
		if (s == e)
			return m;
		L = 1;
		R = m + 1;
		int M = segSum(1, 1, len / 2);
		if (M < (K + 1) / 2)
			return sol(m + 1, e);
		else
			return sol(s, m);
	}

	static int segSum(int NNum, int nodeL, int nodeR) {
		if (R < nodeL || nodeR < L)
			return 0;
		if (L <= nodeL && nodeR <= R)
			return tree[NNum];
		int mid = (nodeL + nodeR) / 2;
		return segSum(NNum * 2, nodeL, mid) + segSum(NNum * 2 + 1, mid + 1, nodeR);
	}

	static void segUpdate(int p, int v) {
		p += len / 2 - 1;
		tree[p] += v;
		while (p > 1) {
			p /= 2;
			tree[p] = tree[p * 2] + tree[p * 2 + 1];
		}
	}
}