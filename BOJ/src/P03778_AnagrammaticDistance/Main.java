package P03778_AnagrammaticDistance;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

	static int T, a[], b[], ans;
	static String A, B;

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/3778.txt");
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		T = Integer.valueOf(br.readLine());

		for (int ts = 1; ts <= T; ts++) {

			A = br.readLine();
			B = br.readLine();

			a = new int[26];
			b = new int[26];

			for (int i = 0; i < A.length(); i++)
				a[A.charAt(i) - 'a']++;
			for (int i = 0; i < B.length(); i++)
				b[B.charAt(i) - 'a']++;

			ans = 0;
			for (int i = 0; i < 26; i++) {
				ans += Math.abs(a[i] - b[i]);
			}

			bw.write("Case #" + ts + ": " + ans + "\n");

		}
		bw.flush();

	}

}