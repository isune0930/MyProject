package P01152_NumberOfWords;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {

	static String sen;
	static int cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		sen = br.readLine();

		for (int i = 0; i < sen.length(); i++)
			if (sen.charAt(i) == ' ' && (i + 1 < sen.length() && sen.charAt(i + 1) != ' '))
				cnt++;

		if (sen.charAt(0) == ' ')
			cnt--;

		System.out.println(cnt + 1);

	}

}