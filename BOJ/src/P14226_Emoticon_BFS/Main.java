package P14226_Emoticon_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {

	static int S, D[][], ans;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = Integer.valueOf(br.readLine());

		D = new int[S + 1][S + 1];
		for (int[] row : D)
			Arrays.fill(row, -1);

		ArrayDeque<Emoticon> dq = new ArrayDeque<Emoticon>();
		D[1][0] = 0;
		dq.add(new Emoticon(1, 0));
		while (!dq.isEmpty()) {
			int s = dq.peek().s;
			int c = dq.peek().c;
			dq.remove();
			if (s == S)
				break;
			if (D[s][s] == -1) {
				D[s][s] = D[s][c] + 1;
				dq.add(new Emoticon(s, s));
			}
			if (s + c <= S && D[s + c][c] == -1) {
				D[s + c][c] = D[s][c] + 1;
				dq.add(new Emoticon(s + c, c));
			}
			if (s - 1 >= 0 && D[s - 1][c] == -1) {
				D[s - 1][c] = D[s][c] + 1;
				dq.add(new Emoticon(s - 1, c));
			}
		}

		ans = Integer.MAX_VALUE;
		for (int i = 0; i <= S; i++)
			if (D[S][i] != -1)
				ans = Math.min(ans, D[S][i]);

		System.out.println(ans);

	}

}

class Emoticon {
	public Emoticon(int s, int c) {
		this.s = s;
		this.c = c;
	}

	int s, c;
}