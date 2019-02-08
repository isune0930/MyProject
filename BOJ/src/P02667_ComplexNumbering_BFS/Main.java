package P02667_ComplexNumbering_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	static int N, A[][], D[][], cnt, ans[];
	final static int[] dx = { 1, -1, 0, 0 };
	final static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/2667.txt");
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		N = Integer.valueOf(br.readLine());
		A = new int[N + 1][N + 1];
		D = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= N; j++)
				A[i][j] = str.charAt(j - 1) - '0';
		}

		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				if (A[i][j] == 1 && D[i][j] == 0)
					dfs(i, j, ++cnt);

		ans = new int[cnt + 1];
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				ans[D[i][j]]++;
		Arrays.sort(ans, 1, cnt);
				
		bw.write(cnt + "\n");
		for (int i = 1; i <= cnt; i++)
			bw.write(ans[i] + "\n");
		bw.flush();

	}

	static void dfs(int x, int y, int cnt) {
		D[x][y] = cnt;
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (nx > 0 && nx <= N && ny > 0 && ny <= N)
				if (A[nx][ny] == 1 && D[nx][ny] == 0)
					dfs(nx, ny, cnt);
		}
	}

}