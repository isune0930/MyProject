package P11650_CoordinateAlignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int N;

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/11650.txt");
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		N = Integer.valueOf(br.readLine());
		Coordinate[] A;
		A = new Coordinate[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());
			A[i] = new Coordinate(x, y);
		}

		Arrays.sort(A, 1, N + 1, new Comparator<Coordinate>() {
			public int compare(Coordinate a, Coordinate b) {
				if (a.x != b.x)
					return a.x - b.x;
				else
					return a.y - b.y;
			}
		});

		for (int i = 1; i <= N; i++) {
			bw.write(A[i].x + " " + A[i].y + "\n");
		}
		bw.flush();

	}
}

class Coordinate {
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int x, y;
}