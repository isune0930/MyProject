package P02178_Maze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int N, M, A[][], D[][];
	static boolean check[][];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/2178.txt");
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());

		A = new int[N + 1][M + 1];
		D = new int[N + 1][M + 1];
		check = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++)
				A[i][j] = str.charAt(j - 1) - '0';
		}

		ArrayDeque<Maze> dq = new ArrayDeque<>();
		check[1][1] = true;
		D[1][1] = 1;
		dq.add(new Maze(1, 1));
		while (!dq.isEmpty()) {
			int x = dq.peek().x;
			int y = dq.peek().y;
			dq.remove();
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (0 < nx && 0 < ny && nx <= M && ny <= N)
					if (A[ny][nx] == 1 && !check[ny][nx]) {
						check[ny][nx] = true;
						D[ny][nx] = D[y][x] + 1;
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