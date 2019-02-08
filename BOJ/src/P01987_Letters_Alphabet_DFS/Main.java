package P01987_Letters_Alphabet_DFS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, A[][];
	static boolean[] check;
	final static int[] dx = { 1, -1, 0, 0 };
	final static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/1987.txt");
		BufferedReader br = new BufferedReader(fr);
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.valueOf(st.nextToken());
		C = Integer.valueOf(st.nextToken());
		A = new int[R + 1][C + 1];
		check = new boolean[26];

		for (int i = 1; i <= R; i++) {
			String str = br.readLine();
			for (int j = 1; j <= C; j++) {
				A[i][j] = str.charAt(j - 1) - 'A';
			}
		}

		check[A[1][1]] = true;
		System.out.println(go(A, check, 1, 1));

	}

	static int go(int[][] A, boolean[] check, int x, int y) {
		int ans = 0;
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (nx > 0 && nx <= R && ny > 0 && ny <= C)
				if (!check[A[nx][ny]]) {
					check[A[nx][ny]] = true;
					int next = go(A, check, nx, ny);
					if (ans < next)
						ans = next;
					check[A[nx][ny]] = false;
				}
		}
		return ans + 1;
	}

}