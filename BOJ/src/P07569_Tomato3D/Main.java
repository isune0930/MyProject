package P07569_Tomato3D;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M, N, H, A[][][], count, ans;
	static int[] di = { -1, 1, 0, 0, 0, 0 };
	static int[] dj = { 0, 0, 1, -1, 0, 0 };
	static int[] dk = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/7569.txt");
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.valueOf(st.nextToken());
		N = Integer.valueOf(st.nextToken());
		H = Integer.valueOf(st.nextToken());

		A = new int[N + 1][M + 1][H + 1];
		Queue<Tomato> q = new LinkedList<>();
		count = 0;
		ans = 1;

		for (int k = 1; k <= H; k++)
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= M; j++) {
					A[i][j][k] = Integer.valueOf(st.nextToken());
					if (A[i][j][k] == 1) {
						count++;
						q.add(new Tomato(i, j, k));
					}
					if (A[i][j][k] == 0)
						count++;
				}
			}

		while (!q.isEmpty()) {
			int hi = q.peek().x;
			int hj = q.peek().y;
			int hk = q.peek().z;
			q.poll();
			count--;
			for (int i = 0; i < 6; i++) {
				int ni = hi + di[i];
				int nj = hj + dj[i];
				int nk = hk + dk[i];
				if (ni < 1 | ni > N | nj < 1 | nj > M | nk < 1 | nk > H)
					continue;
				else if (A[ni][nj][nk] == 0) {
					A[ni][nj][nk] = A[hi][hj][hk] + 1;
					ans = Math.max(ans, A[ni][nj][nk]);
					q.add(new Tomato(ni, nj, nk));
				}
			}
		}

		if (count == 0)
			System.out.println(ans - 1);
		else
			System.out.println(-1);

	}

}

class Tomato {
	public Tomato(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	int x, y, z;
}