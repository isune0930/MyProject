package P03055_SLIKAR_BFS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int R, C, W[][], D[][], sx, sy, ex, ey;
	static char[][] A;
	static boolean[][] check;
	final static int[] dx = { 1, -1, 0, 0 };
	final static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/3055.txt");
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.valueOf(st.nextToken());
		C = Integer.valueOf(st.nextToken());

		A = new char[R + 1][C + 1];
		W = new int[R + 1][C + 1];
		D = new int[R + 1][C + 1];
		check = new boolean[R + 1][C + 1];
		ArrayDeque<Pair> dq = new ArrayDeque<Pair>();
		for (int i = 1; i <= R; i++) {
			String str = br.readLine();
			for (int j = 1; j <= C; j++) {
				A[i][j] = str.charAt(j - 1);
				if (A[i][j] == 'S') {
					sx = i;
					sy = j;
				}
				if (A[i][j] == 'D') {
					ex = i;
					ey = j;
				}
				if (A[i][j] == '*') {
					check[i][j] = true;
					dq.add(new Pair(i, j));
				}
			}
		}

		while (!dq.isEmpty()) {
			int x = dq.peek().x;
			int y = dq.peek().y;
			dq.remove();
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (nx > 0 && nx <= R && ny > 0 && ny <= C && A[nx][ny] == '.'
						&& !check[nx][ny]) {
					W[nx][ny] = W[x][y] + 1;
					check[nx][ny] = true;
					dq.add(new Pair(nx, ny));
				}
			}
		}

		check = new boolean[R + 1][C + 1];
		check[sx][sy] = true;
		dq.add(new Pair(sx, sy));
		while (!dq.isEmpty()) {
			int x = dq.peek().x;
			int y = dq.peek().y;
			dq.remove();
			if (x == ex && y == ey)
				break;
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (nx > 0 && nx <= R && ny > 0 && ny <= C && A[nx][ny] != 'X'
						&& !check[nx][ny]) {
					if (W[nx][ny] == 0 || D[x][y] + 1 < W[nx][ny]) {
						D[nx][ny] = D[x][y] + 1;
						check[nx][ny] = true;
						dq.add(new Pair(nx, ny));
					}
				}
			}
		}

		if (D[ex][ey] == 0)
			System.out.println("KAKTUS");
		else
			System.out.println(D[ex][ey]);

	}

}

class Pair {
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int x, y;
}