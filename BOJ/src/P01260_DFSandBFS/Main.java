package P01260_DFSandBFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N, M, V;
	static ArrayList<Integer>[] A;
	static boolean[] check;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
			System.out));

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/1260.txt");
		BufferedReader br = new BufferedReader(fr);

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		V = Integer.valueOf(st.nextToken());

		A = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			A[i] = new ArrayList<Integer>();
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.valueOf(st.nextToken());
			int v = Integer.valueOf(st.nextToken());
			A[u].add(v);
			A[v].add(u);
		}
		for (int i = 1; i <= N; i++)
			Collections.sort(A[i]);

		check = new boolean[N + 1];
		dfs(V);
		bw.write("\n");
		check = new boolean[N + 1];
		bfs(V);
		bw.write("\n");
		bw.flush();

	}

	static void dfs(int x) throws Exception {
		if (check[x])
			return;
		check[x] = true;
		bw.write(x + " ");
		for (int y : A[x])
			if (!check[y])
				dfs(y);
	}

	static void bfs(int start) throws Exception {
		ArrayDeque<Integer> dq = new ArrayDeque();
		check[start] = true;
		dq.add(start);
		while (!dq.isEmpty()) {
			int x = dq.remove();
			bw.write(x + " ");
			for (int y : A[x])
				if (!check[y]) {
					check[y] = true;
					dq.add(y);
				}
		}
	}

}