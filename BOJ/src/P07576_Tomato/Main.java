package P07576_Tomato;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int M, N, A[][], D[][], cnt, ans;
	final static int[] dx = { 1, -1, 0, 0 };
	final static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/7576.txt");
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.valueOf(st.nextToken());
		N = Integer.valueOf(st.nextToken());
		A = new int[N + 1][M + 1];
		D = new int[N + 1][M + 1];
		for (int[] row : D)
			Arrays.fill(row, -1);

		ArrayDeque<Tomato> dq = new ArrayDeque();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				A[i][j] = Integer.valueOf(st.nextToken());
				if (A[i][j] == 0)
					cnt++;
				if (A[i][j] == 1) {
					D[i][j] = 0;
					dq.add(new Tomato(i, j));
					cnt++;
				}
			}
		}

		ans = -1;
		while (!dq.isEmpty()) {
			int x = dq.peek().x;
			int y = dq.peek().y;
			dq.remove();
			cnt--;
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (nx > 0 && nx <= N && ny > 0 && ny <= M) {
					if (A[nx][ny] == 0 && D[nx][ny] == -1) {
						D[nx][ny] = D[x][y] + 1;
						dq.add(new Tomato(nx, ny));
						ans = Math.max(ans, D[nx][ny]);
					}
				}
			}
		}

		if (cnt == 0)
			System.out.println(ans);
		else
			System.out.println(-1);

	}

}

class Tomato {
	public Tomato(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int x, y;
}