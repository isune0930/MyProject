package P01922_NetworkConnection_MST_Kruskal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int N, M, par[], ans;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		ArrayList<Node> nodes = new ArrayList<>();
		for (int i = 1; i <= M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			nodes.add(new Node(a, b, c));
		}

		Collections.sort(nodes, new Comparator<Node>() {
			public int compare(Node a, Node b) {
				return a.c - b.c;
			}
		});

		par = new int[N + 1];
		for (int i = 1; i <= N; i++)
			par[i] = i;
		for (Node e : nodes) {
			int a = find(e.a);
			int b = find(e.b);
			if (a == b)
				continue;
			par[a] = b;
			ans += e.c;
		}

		System.out.println(ans);

	}

	static int find(int n) {
		if (par[n] == n)
			return n;
		return par[n] = find(par[n]);
	}
}

class Node {
	public Node(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	int a, b, c;
}