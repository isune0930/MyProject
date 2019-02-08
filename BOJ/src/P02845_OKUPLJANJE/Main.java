package P02845_OKUPLJANJE;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	static int L, P, count;

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/2845.txt");
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.valueOf(st.nextToken());
		P = Integer.valueOf(st.nextToken());
		count = L * P;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= 5; i++)
			System.out.print(Integer.valueOf(st.nextToken()) - count + " ");

	}

}