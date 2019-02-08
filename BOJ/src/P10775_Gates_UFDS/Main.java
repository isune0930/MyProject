package P10775_Gates_UFDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int G, P, p[], ans;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());

		p = new int[G + 1];
		for (int i = 1; i <= G; i++)
			p[i] = i;

		for (ans = 0; ans < P; ans++) {
			int x = Integer.parseInt(br.readLine());
			if (find(x) == 0)
				break;
			p[x] = find(x) - 1;
		}
		System.out.println(ans);

	}

	static int find(int x) {
		if (p[x] == x)
			return x;
		return p[x] = find(p[x]);
	}

}