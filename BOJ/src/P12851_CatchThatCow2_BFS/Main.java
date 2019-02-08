package P12851_CatchThatCow2_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, K, D[], cnt[];
	final static int MAX = 133333;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());

		D = new int[MAX];
		Arrays.fill(D, -1);
		cnt = new int[MAX];

		ArrayDeque<Integer> dq = new ArrayDeque<>();
		D[N] = 0;
		cnt[N] = 1;
		dq.add(N);
		while (!dq.isEmpty()) {
			int x = dq.remove();
			if (x == K)
				break;
			for (int next : new int[] { x - 1, x + 1, 2 * x })
				if (next >= 0 && next < MAX) {
					if (D[next] == -1) {
						D[next] = D[x] + 1;
						cnt[next] = cnt[x];
						dq.add(next);
					} else if (D[next] == D[x] + 1)
						cnt[next] += cnt[x];
				}
		}

		bw.write(D[K] + "\n" + cnt[K]);
		bw.flush();

	}

}