package P03460_BinaryNumbers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	static int T, N;

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/3460.txt");
		BufferedReader br = new BufferedReader(fr);

		T = Integer.valueOf(br.readLine());

		for (int ts = 1; ts <= T; ts++) {

			N = Integer.valueOf(br.readLine());

			for (int i = 0; i <= 19; i++)
				if ((N & (1 << i)) != 0)
					System.out.print(i + " ");

		}

	}

}