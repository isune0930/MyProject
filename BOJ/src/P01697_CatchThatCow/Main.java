package P01697_CatchThatCow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int N, K, dist[], x;
	final static int MAX = 133333;
	static boolean check[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		K = Integer.valueOf(st.nextToken());

		check = new boolean[MAX];
		dist = new int[MAX];
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		check[N] = true;
		dq.add(N);
		while (!dq.isEmpty()) {
			x = dq.remove();
			if (x == K)
				break;
			for (int next : new int[] { x - 1, x + 1, 2 * x })
				if (next >= 0 && next < MAX && !check[next]) {
					check[next] = true;
					dist[next] = dist[x] + 1;
					dq.add(next);
				}
		}
		
		System.out.println(dist[K]);

	}

}
