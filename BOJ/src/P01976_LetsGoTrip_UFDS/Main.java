package P01976_LetsGoTrip_UFDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, p[], t[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		p = new int[N + 1];
		for (int i = 1; i <= N; i++)
			p[i] = i;

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				if (Integer.parseInt(st.nextToken()) == 1)
					union(i, j);
		}

		t = new int[M + 1];
		String ans = "YES";
		StringTokenizer st = new StringTokenizer(br.readLine());
		t[1] = Integer.parseInt(st.nextToken());
		for (int i = 2; i <= M; i++) {
			t[i] = Integer.parseInt(st.nextToken());
			if (!isSame(t[i - 1], t[i])) {
				ans = "NO";
				break;
			}
		}

		System.out.println(ans);

	}

	static void union(int a, int b) {
		if (!isSame(a, b))
			p[find(b)] = find(a);
	}

	static boolean isSame(int a, int b) {
		return find(a) == find(b);
	}

	static int find(int a) {
		if (p[a] == a)
			return a;
		return p[a] = find(p[a]);
	}

}
