package P14432_Well_DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, M, W[];
	static long ans;
	static ArrayList<Integer>[] A;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());

		W = new int[N + 1];
		A = new ArrayList[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			W[i] = Integer.valueOf(st.nextToken());
			A[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.valueOf(st.nextToken());
			int v = Integer.valueOf(st.nextToken());
			A[u].add(v);
			A[v].add(u);
		}

		ans = 0;
		dfs(1, 0);
		if (W[1] > 0)
			ans += W[1];
		bw.write(ans + "\n");
		bw.flush();

	}

	static void dfs(int x, int par) {
		int max = 0;
		for (int y : A[x])
			if (y != par) {
				dfs(y, x);
				max = Math.max(max, W[y]);
			}
		ans += max;
		for (int y : A[x])
			W[y] -= max;
		W[x] -= max;
	}

}