package P11758_CCW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int X[], Y[], CCW;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		X = new int[4];
		Y = new int[4];
		for (int i = 1; i <= 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			X[i] = Integer.valueOf(st.nextToken());
			Y[i] = Integer.valueOf(st.nextToken());
		}

		CCW = X[1] * Y[2] + X[2] * Y[3] + X[3] * Y[1] - Y[1] * X[2] - Y[2]
				* X[3] - Y[3] * X[1];
		if (CCW > 0)
			System.out.println(1);
		else if (CCW < 0)
			System.out.println(-1);
		else
			System.out.println(0);

	}

}