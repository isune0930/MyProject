package P07976_Sequence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	static int n, k, a[], EO[][], ans, mingap = Integer.MAX_VALUE, chk;

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/7976.txt");
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());

		a = new int[n + 1];
		EO = new int[k][2];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			a[i] = Integer.valueOf(st.nextToken());
			EO[i % k][a[i] & 1]++;
		}

		for (int i = 0; i < k; i++) {
			ans += Math.min(EO[i][0], EO[i][1]);
			mingap = Math.min(mingap, Math.abs(EO[i][0] - EO[i][1]));
			if (EO[i][0] < EO[i][1])
				chk ^= 1;
		}

		System.out.println(ans + mingap * chk);

	}

}