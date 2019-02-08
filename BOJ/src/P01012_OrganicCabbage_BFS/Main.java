package P01012_OrganicCabbage_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int T, M, N, K, A[][], X, Y, cnt;
	static ArrayDeque<Pair> dq;
	final static int[] dx = { 1, -1, 0, 0 };
	final static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.valueOf(br.readLine());
		while (T-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.valueOf(st.nextToken());
			N = Integer.valueOf(st.nextToken());
			K = Integer.valueOf(st.nextToken());

			A = new int[N + 1][M + 1];
			while (K-- > 0) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.valueOf(st.nextToken());
				int Y = Integer.valueOf(st.nextToken());
				A[Y + 1][X + 1] = 1;
			}

			cnt = 0;
			dq = new ArrayDeque<Pair>();
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (A[i][j] == 1) {
						cnt++;
						A[i][j] += cnt;
						dq.add(new Pair(i, j));
						while (!dq.isEmpty()) {
							int x = dq.peek().x;
							int y = dq.peek().y;
							dq.remove();
							for (int k = 0; k < 4; k++) {
								int nx = x + dx[k];
								int ny = y + dy[k];
								if (nx > 0 && nx <= N && ny > 0 && ny <= M
										&& A[nx][ny] == 1) {
									A[nx][ny] = A[x][y];
									dq.add(new Pair(nx, ny));
								}
							}
						}
					}
				}
			}

			System.out.println(cnt);

		}

	}

}

class Pair {
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int x, y;
}