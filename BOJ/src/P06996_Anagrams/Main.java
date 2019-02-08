package P06996_Anagrams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int T;
	static char a[], b[];
	static String A, B, ans;

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/6996.txt");
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		T = Integer.valueOf(br.readLine());

		for (int ts = 1; ts <= T; ts++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			A = st.nextToken();
			B = st.nextToken();

			ans = " are anagrams.";
			if (A.length() != B.length())
				ans = " are NOT anagrams.";
			else {
				a = A.toCharArray();
				b = B.toCharArray();
				Arrays.sort(a);
				Arrays.sort(b);
				for (int i = 0; i < A.length(); i++)
					if (a[i] != b[i]) {
						ans = " are NOT anagrams.";
						break;
					}
			}
			bw.write(A + " & " + B + ans + "\n");
			bw.flush();

		}

	}

}