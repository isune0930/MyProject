package P01958_LCS3;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

	static String Astr, Bstr, Cstr;
	static int N, M, L, D[][][];
	static char A[], B[], C[];

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/1958.txt");
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

		Cstr = br.readLine();
		L = Cstr.length();
		C = new char[L + 1];
		for (int i = 1; i <= L; i++)
			C[i] = Cstr.charAt(i - 1);

		D = new int[N + 1][M + 1][L + 1];
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= M; j++)
				for (int k = 1; k <= L; k++) {
					D[i][j][k] = Math.max(
							Math.max(D[i - 1][j][k], D[i][j - 1][k]),
							D[i][j][k - 1]);
					if (A[i] == B[j] && A[i] == C[k])
						D[i][j][k] = Math.max(D[i][j][k],
								D[i - 1][j - 1][k - 1] + 1);
				}

		System.out.println(D[N][M][L]);

	}
}