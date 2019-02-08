package P02522_PrintingStarts_12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		N = Integer.valueOf(br.readLine());

		for (int i = 1; i <= 2 * N - 1; i++) {
			for (int j = 1; j <=N ; j++) {
				if (i <= N) {
					if (j > N - i)
						bw.write("*");
					else
						bw.write(" ");
				} else {
					if (j > i - N)
						bw.write("*");
					else
						bw.write(" ");
				}
			}
			bw.write("\n");
		}
		bw.flush();

	}
}