package P01002_Turret;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	static double T, x1, y1, r1, x2, y2, r2, d1, d2, d3;

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/1002.txt");
		// InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(fr);

		T = Integer.parseInt(br.readLine());

		for (int ts = 1; ts <= T; ts++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());

			d1 = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);
			d2 = Math.pow(r1 + r2, 2);

			if (x1 == x2 && y1 == y2 && r1 == r2) {
				System.out.println("-1");
			} else {
				if (d1 > d2) {
					System.out.println("0");
					continue;
				} else if (d1 == d2) {
					System.out.println("1");
					continue;
				} else {
					d3 = Math.pow(r2 - r1, 2);
					if (d1 == d3) {
						System.out.println("1");
						continue;
					} else if (d1 < d3) {
						System.out.println("0");
						continue;
					} else
						System.out.println("2");

				}

			}

		}

	}

}
