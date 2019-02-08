package P01919_MakingAnagram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	static String A, B;
	static int a[], b[], ans;

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/1919.txt");
		BufferedReader br = new BufferedReader(fr);

		A = br.readLine();
		B = br.readLine();

		a = new int[26];
		b = new int[26];

		for (int i = 0; i < A.length(); i++)
			a[A.charAt(i) - 'a']++;
		for (int i = 0; i < B.length(); i++)
			b[B.charAt(i) - 'a']++;

		for (int i = 0; i < 26; i++)
			ans += Math.abs(a[i] - b[i]);

		System.out.println(ans);

	}

}