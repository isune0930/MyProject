package P01781_CupRamen_Greedy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int N, ans;

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/1781.txt");
		BufferedReader br = new BufferedReader(fr);

		N = Integer.parseInt(br.readLine());
		Ramen[] A;
		A = new Ramen[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			A[i] = new Ramen(d, c);
		}

		Arrays.sort(A, 1, N, new Comparator<Ramen>() {
			public int compare(Ramen a, Ramen b) {
				if (a.d == b.d)
					return b.c - a.c;
				return a.d - b.d;
			}
		});
		ans = A[1].c;
		for (int i = 2; i <= N; i++)
			if (A[i].d > A[i - 1].d)
				ans += A[i].c;

		System.out.println(ans);

	}

}

class Ramen {
	public Ramen(int d, int c) {
		this.d = d;
		this.c = c;
	}

	int d, c;
}