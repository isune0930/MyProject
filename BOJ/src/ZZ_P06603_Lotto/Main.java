package ZZ_P06603_Lotto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	static int K, S[];

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/6603.txt");
		BufferedReader br = new BufferedReader(fr);

		while (true) {
			String str = br.readLine();
			System.out.println(str);
			if (str.equals("0"))
				break;

		}

	}

}