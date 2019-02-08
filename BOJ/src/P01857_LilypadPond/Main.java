package P01857_LilypadPond;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int m, n, A[][];
	static boolean check[][];

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/1857.txt");
		BufferedReader br = new BufferedReader(fr);
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.valueOf(st.nextToken());
		n = Integer.valueOf(st.nextToken());
		Lilypad[][] A;
		A = new Lilypad[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				A[i][j] = new Lilypad(j, i, Integer.valueOf(st.nextToken()));
			}
		}

	}
}

class Lilypad {
	public Lilypad(int x, int y, int pad) {
		this.x = x;
		this.y = y;
		this.pad = pad;
	}

	int x, y, pad;
}