package P09252_LCS2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

	static String Astr, Bstr;
	static int N, M, D[][], E[][];
	static char A[], B[];

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/9252.txt");
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
		E = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= M; j++) {
				if (D[i - 1][j] > D[i][j - 1]) {
					D[i][j] = D[i - 1][j];
					E[i][j] = 1;
				} else {
					D[i][j] = D[i][j - 1];
					E[i][j] = 2;
				}
				if (A[i] == B[j] && D[i][j] < D[i - 1][j - 1] + 1) {
					D[i][j] = D[i - 1][j - 1] + 1;
					E[i][j] = 3;
				}
			}

		StringBuilder sb = new StringBuilder();
		for (int i = N, j = M; i > 0 && j > 0;) {
			if (E[i][j] == 1)
				i--;
			else if (E[i][j] == 2)
				j--;
			else {
				sb.append(A[i]);
				i--;
				j--;
			}
		}
		
		System.out.println(D[N][M]);
		System.out.println(sb.reverse());

	}
}