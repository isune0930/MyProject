package P13913_CatchThatCow4_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, K, D[], from[];
	final static int MAX = 133333;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());

		D = new int[MAX];
		from = new int[MAX];
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
					D[next] = D[x] + 1;
					from[next] = x;
					dq.add(next);
				}
		}

		dq.clear();
		for (int i = K; i != N; i = from[i])
			dq.addFirst(i);
		dq.addFirst(N);

		bw.write(D[K] + "\n");
		while (!dq.isEmpty()) {
			bw.write(dq.remove() + " ");
		}
		bw.flush();

	}

}