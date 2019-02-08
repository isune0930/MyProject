package P01929_PrimeNumber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int M, N;
	static boolean[] check;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.valueOf(st.nextToken());
		N = Integer.valueOf(st.nextToken());
		check = new boolean[N + 1];
		check[0] = check[1] = true;
		for (int i = 2; i * i <= N; i++)
			if (!check[i])
				for (int j = i + i; j <= N; j += i)
					check[j] = true;

		for (int i = M; i <= N; i++)
			if (!check[i])
				bw.write(i + "\n");
		bw.flush();
	}

}