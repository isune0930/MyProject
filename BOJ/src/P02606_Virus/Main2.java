package P02606_Virus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {

	static int M, V, ans;
	static ArrayList<Integer> A[];
	static boolean check[];

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("C:/BOJ/2606.txt");
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(br.readLine());
		V = Integer.valueOf(st.nextToken());

		A = new ArrayList[M + 1];
		for (int i = 1; i <= M; i++)
			A[i] = new ArrayList<Integer>();

		for (int i = 1; i <= V; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.valueOf(st.nextToken());
			int v = Integer.valueOf(st.nextToken());
			A[u].add(v);
			A[v].add(u);
		}

		check = new boolean[M + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		check[1] = true;
		while (!q.isEmpty()) {
			int x = q.remove();
			for (int y : A[x]) {
				if (!check[y]) {
					q.add(y);
					check[y] = true;
					ans++;
				}

			}
		}

		System.out.println(ans);

	}

}