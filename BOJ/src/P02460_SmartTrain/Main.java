package P02460_SmartTrain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Main {

	static int out, in, cur, max;

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/2460.txt");
		BufferedReader br = new BufferedReader(fr);

		for (int i = 1; i <= 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			out = Integer.valueOf(st.nextToken());
			in = Integer.valueOf(st.nextToken());
			cur = cur - out + in;
			max = Math.max(max, cur);
		}
		System.out.println(max);

	}

}