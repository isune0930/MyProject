package P01263_TimeManagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main2 {

	static int N, ans;

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/1263.txt");
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		ToDo[] A;
		A = new ToDo[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			A[i] = new ToDo(t, s);
		}

		Arrays.sort(A, 1, N + 1, new Comparator<ToDo>() {
			public int compare(ToDo a, ToDo b) {
				return a.s - b.s;
			}
		});

		ans = A[N].s;
		for (int i = N; i >= 1; i--) {
			ans = Math.min(ans, A[i].s);
			ans -= A[i].t;
		}

		if (ans >= 0)
			System.out.println(ans);
		else
			System.out.println(-1);

	}

}

class ToDo {
	public ToDo(int t, int s) {
		this.t = t;
		this.s = s;
	}

	int t, s;
}