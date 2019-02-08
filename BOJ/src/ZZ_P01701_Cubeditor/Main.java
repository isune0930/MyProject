package ZZ_P01701_Cubeditor;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		//long start = System.currentTimeMillis();

		System.setIn(new FileInputStream("C:/BOJ/1701.txt"));
		Scanner sc = new Scanner(System.in);

		//String s = new StringBuffer(sc.nextLine()).reverse().toString();
		String s = sc.nextLine();
		char[] S = new char[s.length()];
		S = s.toCharArray();

		String a = "";
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			a += S[i];
			//System.out.println(a);
			int[] next = new int[a.length()];
			next = preprocessing(a);
			for (int j = 0; j < a.length(); j++) {
				//System.out.print(next[j]);
				if (ans < next[j])
					ans = next[j];
			}
			//System.out.println();
		}
		System.out.println(ans);

		//long end = System.currentTimeMillis();
		//System.out.println("수행시간 : " + (end - start));

	}

	static int[] preprocessing(String p) {
		int m = p.length(), j = 0;
		int[] pi = new int[m];
		pi[0] = 0;
		char[] P = new char[m];
		P = p.toCharArray();
		for (int i = 1; i < m; i++) {
			while (j > 0 && P[i] != P[j]) {
				j = pi[j - 1];
			}
			if (P[i] == P[j]) {
				pi[i] = j + 1;
				j += 1;
			} else {
				pi[i] = 0;
			}
		}
		return pi;
	}

}
