package P02605_LineUp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Main {

	static int N, A[], k, tmp;

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/2605.txt");
		BufferedReader br = new BufferedReader(fr);
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		A = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = i;
			k = Integer.valueOf(st.nextToken());
			for (int j = i; j > i - k; j--) {
				tmp = A[j - 1];
				A[j - 1] = A[j];
				A[j] = tmp;
			}
		}

		for (int i = 1; i <= N; i++)
			System.out.print(A[i] + " ");

	}

}