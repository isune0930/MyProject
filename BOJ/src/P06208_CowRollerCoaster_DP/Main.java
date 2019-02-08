package P06208_CowRollerCoaster_DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int L, N, B, D[][], ans;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		D = new int[L + 1][B + 1];
		Rolco[] A;
		A = new Rolco[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			A[i] = new Rolco(x, w, f, c);
		}

		Arrays.sort(A, 1, N, new Comparator<Rolco>() {
			public int compare(Rolco a, Rolco b) {
				return a.x - b.x;
			}
		});

		for (int i = 1; i <= N; i++) {
			int end = A[i].x + A[i].w;
			if (A[i].x == 0) {
				D[end][A[i].c] = Math.max(D[end][A[i].c], A[i].f);
				continue;
			}
			for (int j = 1; j <= B; j++)
				if (D[A[i].x][j] > 0 && j + A[i].c <= B)
					D[end][j + A[i].c] = Math.max(D[end][j + A[i].c],
							D[A[i].x][j] + A[i].f);
		}

		for (int i = 1; i <= B; i++)
			ans = Math.max(ans, D[L][i]);
		if (ans == 0)
			System.out.println(-1);
		else
			System.out.println(ans);

	}

}

class Rolco {
	public Rolco(int x, int w, int f, int c) {
		this.x = x;
		this.w = w;
		this.f = f;
		this.c = c;
	}

	int x, w, f, c;
}