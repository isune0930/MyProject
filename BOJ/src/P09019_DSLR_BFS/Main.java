package P09019_DSLR_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int T, A, B, from[];
	static boolean[] check;
	static char[] how;

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/9019.txt");
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		T = Integer.valueOf(br.readLine());
		while (T-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.valueOf(st.nextToken());
			B = Integer.valueOf(st.nextToken());

			check = new boolean[10000];
			from = new int[10000];
			how = new char[10000];
			ArrayDeque<Integer> dq = new ArrayDeque<Integer>();

			check[A] = true;
			dq.add(A);
			while (!dq.isEmpty()) {
				int x = dq.remove();
				if (x == B)
					break;
				int D = Dcal(x);
				int S = Scal(x);
				int L = Lcal(x);
				int R = Rcal(x);
				if (!check[D]) {
					check[D] = true;
					from[D] = x;
					how[D] = 'D';
					dq.add(D);
				}
				if (!check[S]) {
					check[S] = true;
					from[S] = x;
					how[S] = 'S';
					dq.add(S);
				}
				if (!check[L]) {
					check[L] = true;
					from[L] = x;
					how[L] = 'L';
					dq.add(L);
				}
				if (!check[R]) {
					check[R] = true;
					from[R] = x;
					how[R] = 'R';
					dq.add(R);
				}
			}

			StringBuilder sb = new StringBuilder();
			for (int i = B; i != A; i = from[i])
				sb.append(how[i]);
			bw.write(sb.reverse() + "\n");

		}
		bw.flush();

	}

	static int Dcal(int x) {
		return 2 * x % 10000;
	}

	static int Scal(int x) {
		if (x == 0)
			return 9999;
		return x - 1;
	}

	static int Lcal(int x) {
		return x % 1000 * 10 + x / 1000;
	}

	static int Rcal(int x) {
		return x % 10 * 1000 + x / 10;
	}

}
