package P01963_PrimePath_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int T, A, B, D[];
	static boolean prime[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		prime = new boolean[10000];
		for (int i = 2; i * i < 10000; i++)
			if (!prime[i])
				for (int j = i + i; j < 10000; j += i)
					prime[j] = true;

		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			D = new int[10000];
			Arrays.fill(D, -1);
			ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
			D[A] = 0;
			dq.add(A);
			while (!dq.isEmpty()) {
				int x = dq.remove();
				if (x == B)
					break;
				int index = 1;
				for (int k = 0; k < 4; k++) {
					int pivot = (x / index) % 10;
					for (int i = 0; i <= 9; i++) {
						int nx = x + (i - pivot) * index;
						if (nx >= 1000 && !prime[nx] && D[nx] == -1) {
							D[nx] = D[x] + 1;
							dq.add(nx);
						}
					}
					index *= 10;
				}
			}

			System.out.println(D[B]);
		}

	}

}