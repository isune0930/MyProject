package P02206_BreakingWalls_BFS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int N, M, A[][], D[][][];
	final static int[] dx = { 1, -1, 0, 0 };
	final static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/2206.txt");
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());

		A = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++)
				A[i][j] = str.charAt(j - 1) - '0';
		}

		D = new int[N + 1][M + 1][2];
		ArrayDeque<Breakwall> dq = new ArrayDeque<Breakwall>();
		D[1][1][0] = 1;
		dq.add(new Breakwall(1, 1, 0));
		while (!dq.isEmpty()) {
			int x = dq.peek().x;
			int y = dq.peek().y;
			int z = dq.peek().z;
			dq.remove();
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (nx > 0 && nx <= N && ny > 0 && ny <= M) {
					if (A[nx][ny] == 0 && D[nx][ny][z] == 0) {
						D[nx][ny][z] = D[x][y][z] + 1;
						dq.add(new Breakwall(nx, ny, z));
					}
					if (z == 0 && A[nx][ny] == 1 && D[nx][ny][1] == 0) {
						D[nx][ny][1] = D[x][y][0] + 1;
						dq.add(new Breakwall(nx, ny, 1));
					}
				}
			}
		}

		if (D[N][M][0] != 0 && D[N][M][1] != 0) {
			System.out.println(Math.min(D[N][M][0], D[N][M][1]));
		} else if (D[N][M][0] != 0) {
			System.out.println(D[N][M][0]);
		} else if (D[N][M][1] != 0) {
			System.out.println(D[N][M][1]);
		} else {
			System.out.println(-1);
		}

	}

}

class Breakwall {
	public Breakwall(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	int x, y, z;
}