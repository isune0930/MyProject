package P03780_CorporativeNetwork_UFDS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int T, N, p[], d[], P;

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/3780.txt");
		BufferedReader br = new BufferedReader(fr);
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			p = new int[N + 1];
			for (int i = 1; i <= N; i++)
				p[i] = i;
			d = new int[N + 1];

			while (true) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String S = st.nextToken();
				if (S.equals("O"))
					break;
				else if (S.equals("E")) {
					int I = Integer.parseInt(st.nextToken());
					bw.write(find(I) + "\n");
				} else {
					int I = Integer.parseInt(st.nextToken());
					int J = Integer.parseInt(st.nextToken());
					union(I, J);
				}
			}
		}
		bw.flush();

	}

	static int find(int i) {
		if (p[i] != i) {
			d[i] += find(p[i]);
			p[i] = P;
		} else
			P = i;
		return d[i];
	}

	static void union(int i, int j) {
		find(i);
		if (p[i] != j) {
			p[p[i]] = j;
			d[i] = Math.abs(i - j) % 1000;
		}
	}

}