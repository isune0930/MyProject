package P02914_FAKTOR;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/2914.txt");
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.valueOf(st.nextToken());
		int I = Integer.valueOf(st.nextToken());

		System.out.println(A * (I - 1) + 1);

	}

}
