package P10868_MinimumValue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N, M, A[], h, tree_size, tree[];

	public static void main(String[] args) throws Exception {

		FileReader fr = new FileReader("C:/BOJ/10868.txt");
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = Integer.valueOf(br.readLine());

		h = (int) Math.ceil(Math.log(N) / Math.log(2));
		tree_size = (1 << (h + 1));
		tree = new int[tree_size];
		init(1, 0, N - 1);

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.valueOf(st.nextToken());
			int right = Integer.valueOf(st.nextToken());
			bw.write(query(1, 0, N - 1, left - 1, right - 1) + "\n");
		}
		bw.flush();

	}

	static void init(int node, int start, int end) {
		if (start == end)
			tree[node] = A[start];
		else {
			int mid = (start + end) / 2;
			init(node * 2, start, mid);
			init(node * 2 + 1, mid + 1, end);
			tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
		}
	}

	static int query(int node, int start, int end, int i, int j) {
		if (i > end || j < start)
			return -1;
		if (i <= start && end <= j)
			return tree[node];
		int mid = (start + end) / 2;
		int m1 = query(2 * node, start, mid, i, j);
		int m2 = query(2 * node + 1, mid + 1, end, i, j);
		if (m1 == -1)
			return m2;
		else if (m2 == -1)
			return m1;
		else
			return Math.min(m1, m2);
	}

}