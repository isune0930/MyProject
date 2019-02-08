package P11725_TreeParentFinding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, depth[], parent[];
	static ArrayList<Integer>[] A;
	static boolean[] check;

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/11725.txt");
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));

		N = Integer.valueOf(br.readLine());
		A = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			A[i] = new ArrayList();
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.valueOf(st.nextToken());
			int v = Integer.valueOf(st.nextToken());
			A[u].add(v);
			A[v].add(u);
		}

		depth = new int[N + 1];
		parent = new int[N + 1];
		check = new boolean[N + 1];
		ArrayDeque<Integer> dq = new ArrayDeque();

		depth[1] = 0;
		parent[1] = 0;
		check[1] = true;
		dq.add(1);
		while (!dq.isEmpty()) {
			int x = dq.remove();
			for (int y : A[x])
				if (!check[y]) {
					depth[y] = depth[x] + 1;
					parent[y] = x;
					check[y] = true;
					dq.add(y);
				}
		}

		for (int i = 2; i <= N; i++)
			bw.write(parent[i] + "\n");
		bw.flush();

	}

}