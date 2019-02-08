package P09251_LCS;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

	static String Astr, Bstr;
	static int N, M, D[][];
	static char A[], B[];

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/9251.txt");
		BufferedReader br = new BufferedReader(fr);

		Astr = br.readLine();
		N = Astr.length();
		A = new char[N + 1];
		for (int i = 1; i <= N; i++)
			A[i] = Astr.charAt(i - 1);

		Bstr = br.readLine();
		M = Bstr.length();
		B = new char[M + 1];
		for (int i = 1; i <= M; i++)
			B[i] = Bstr.charAt(i - 1);

		D = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= M; j++) {
				D[i][j] = Math.max(D[i - 1][j], D[i][j - 1]);
				if (A[i] == B[j])
					D[i][j] = Math.max(D[i][j], D[i - 1][j - 1] + 1);
			}

		System.out.println(D[N][M]);

	}
}