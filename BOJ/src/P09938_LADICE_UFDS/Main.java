package P09938_LADICE_UFDS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N, L, p[];
	static boolean[] check;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		p = new int[L + 1];
		for (int i = 1; i <= L; i++)
			p[i] = i;

		check = new boolean[L + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			if (!check[A]) {
				check[A] = true;
				union(A, B);
			} else if (!check[B]) {
				check[B] = true;
				union(B, A);
			} else if (!check[find(A)]) {
				check[find(A)] = true;
				union(A, B);
			} else if (!check[find(B)]) {
				check[find(B)] = true;
				union(B, A);
			} else {
				bw.write("SMECE\n");
				continue;
			}
			bw.write("LADICA\n");
		}
		bw.flush();

	}

	static int find(int a) {
		if (p[a] == a)
			return a;
		return p[a] = find(p[a]);
	}

	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if (x == y)
			return;
		p[x] = y;
	}

}