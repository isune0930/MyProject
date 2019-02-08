package P11728_CombineArrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int T, N, M, A[];

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/11728.txt");
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		T = Integer.valueOf(br.readLine());

		for (int ts = 1; ts <= T; ts++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.valueOf(st.nextToken());
			M = Integer.valueOf(st.nextToken());

			A = new int[N + M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				A[i] = Integer.valueOf(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = N; i < N + M; i++)
				A[i] = Integer.valueOf(st.nextToken());

			Arrays.sort(A);
			for (int i = 0; i < N + M; i++)
				bw.write(A[i] + " ");
			bw.write("\n");

		}
		bw.flush();

	}

}