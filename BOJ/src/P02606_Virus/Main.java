package P02606_Virus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans;
	static ArrayList<Integer> A[];
	static boolean check[];

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/2606.txt");
		BufferedReader br = new BufferedReader(fr);

		N = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.valueOf(st.nextToken());

		A = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.valueOf(st.nextToken());
			int v = Integer.valueOf(st.nextToken());
			A[u].add(v);
			A[v].add(u);
		}

		check = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		check[1] = true;
		while (!q.isEmpty()) {
			int x = q.remove();
			for (int y : A[x])
				if (!check[y]) {
					check[y] = true;
					ans++;
					q.add(y);
				}
		}

		System.out.println(ans);

	}

}