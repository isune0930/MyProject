package P01152_NumberOfWords;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static char S[];
	static int cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = br.readLine().toCharArray();

		for (int i = 0; i < S.length; i++)
			if (S[i] == ' ' && (i + 1 < S.length && S[i + 1] != ' '))
				cnt++;

		if (S[0] == ' ')
			cnt--;

		System.out.println(cnt + 1);

	}

}