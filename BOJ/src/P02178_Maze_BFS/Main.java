package P02178_Maze_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, A[][], D[][];
	final static int[] dx = { 1, -1, 0, 0 };
	final static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		A = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++)
				A[i][j] = str.charAt(j - 1) - '0';
		}

		D = new int[N + 1][M + 1];
		for (int[] row : D)
			Arrays.fill(row, -1);

		ArrayDeque<Maze> dq = new ArrayDeque<Maze>();
		D[1][1] = 1;
		dq.add(new Maze(1, 1));
		while (!dq.isEmpty()) {
			int x = dq.peek().x;
			int y = dq.peek().y;
			dq.remove();
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (nx > 0 && nx <= N && ny > 0 && ny <= M)
					if (A[nx][ny] == 1 && D[nx][ny] == -1) {
						D[nx][ny] = D[x][y] + 1;
						dq.add(new Maze(nx, ny));
					}
			}
		}

		System.out.println(D[N][M]);

	}

}

class Maze {
	public Maze(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int x, y;
}