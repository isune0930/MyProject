package P13549_CatchThatCow3_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, K, D[];
	final static int MAX = 133333;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());

		D = new int[MAX];
		Arrays.fill(D, -1);

		ArrayDeque<Integer> dq = new ArrayDeque();
		D[N] = 0;
		dq.add(N);
		while (!dq.isEmpty()) {
			int x = dq.remove();
			if (x == K)
				break;
			for (int next : new int[] { x - 1, x + 1, 2 * x })
				if (next >= 0 && next < MAX && D[next] == -1) {
					if (next == 2 * x) {
						D[next] = D[x];
						dq.addFirst(next);
					} else {
						D[next] = D[x] + 1;
						dq.add(next);
					}
				}
		}

		System.out.println(D[K]);

	}

}