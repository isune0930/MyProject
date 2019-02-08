package P06359_TheDrunkJailer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	static int T, N, D[];

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/6359.txt");
		BufferedReader br = new BufferedReader(fr);

		D = new int[101];
		for (int i = 1; i <= 100; i++)
			D[i] = (int) Math.sqrt(i);

		T = Integer.valueOf(br.readLine());
		for (int ts = 1; ts <= T; ts++) {
			N = Integer.valueOf(br.readLine());
			System.out.println(D[N]);
		}

	}

}