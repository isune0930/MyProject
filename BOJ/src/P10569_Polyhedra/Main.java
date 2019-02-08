package P10569_Polyhedra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int T, V, E;

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/10569.txt");
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		T = Integer.valueOf(br.readLine());
		for (int ts = 1; ts <= T; ts++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.valueOf(st.nextToken());
			E = Integer.valueOf(st.nextToken());
			bw.write(2 - V + E + "\n");
		}
		bw.flush();

	}

}