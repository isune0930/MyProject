package P01717_GatheringExpression_UFDS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int n, m, par[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		par = new int[n + 1];
		for (int i = 0; i <= n; i++)
			par[i] = i;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (x == 0)
				union(a, b);
			else {
				if (find(a) == find(b))
					bw.write("YES\n");
				else
					bw.write("NO\n");
			}
		}
		bw.flush();

	}

	static int find(int x) {
		if (par[x] == x)
			return x;
		return par[x] = find(par[x]);
	}

	static void union(int a, int b) {
		int p = find(a);
		int q = find(b);
		if (p == q)
			return;
		par[q] = p;
	}

}